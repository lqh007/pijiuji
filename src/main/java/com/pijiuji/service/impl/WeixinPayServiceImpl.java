package com.pijiuji.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.*;
import com.pijiuji.service.WeixinPayService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.*;
import com.pijiuji.util.weixin.Utils.HttpXmlUtils;
import com.pijiuji.util.weixin.Utils.RandCharsUtils;
import com.pijiuji.util.weixin.Utils.WXSignUtils;
import com.pijiuji.util.weixin.Utils.WeixinPayUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private LevelFcMapper levelFcMapper;
    @Autowired
    private UserLotteryMapper userLotteryMapper;
    @Autowired
    private TixianMapper tixianMapper;


    /**
     * 生成二维码
     *
     * @return
     */
    @Override
    public Map createNative(String out_trade_no, HttpServletRequest request) {
        //获取金额
        String money = request.getParameter("money");
        if (StringUtils.isEmpty(money)) {
            throw new ServiceException("金额不允许为空");
        }
        //获取商品id
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("商品id不允许为空");
        }
        //获取毫升
        String productSize = request.getParameter("productSize");
        if (StringUtils.isEmpty(productSize)) {
            throw new ServiceException("毫升数不允许为空");
        }
        //获取机器id
        String specId = request.getParameter("specId") == null ? "" : request.getParameter("specId");
        //员工id
        String employeeId = request.getParameter("employeeId") == null ? "" : request.getParameter("employeeId");
        String num = request.getParameter("num");
        if (StringUtils.isEmpty(num)) {
            //如果没有数量则默认为1杯
            num = "1";
        }
        //订单备注，公众号时才有
        String point = request.getParameter("point") == null?"":request.getParameter("point");
        DecimalFormat df = new DecimalFormat("######0");
        Double m = Double.valueOf(money) * 100;
        //支付金额(单位为：分)
        String payMoney = df.format(m);
        //1.创建参数
        Map<String, String> param = new HashMap();//创建参数
        param.put("appid", Param.APPID);//公众号
        param.put("mch_id", Param.mch_id);//商户号
        param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        param.put("body", "啤小生");//商品描述
        param.put("out_trade_no", out_trade_no);//商户订单号
        param.put("total_fee", payMoney);//总金额（分）
        param.put("spbill_create_ip", "127.0.0.1");//IP
        param.put("notify_url", Param.NOTIFY_URL);//回调地址(随便写)
        param.put("trade_type", "NATIVE");//交易类型
        try {
            //2.生成要发送的xml
            String xmlParam = WXPayUtil.generateSignedXml(param, Param.key);
            System.out.println(xmlParam);
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            client.setHttps(true);
            client.setXmlParam(xmlParam);
            client.post();
            //3.获得结果
            String results = client.getContent();
            System.err.println(results);
            Map<String, String> resultMap = WXPayUtil.xmlToMap(results);
            if (StringUtils.isEmpty(resultMap.get("code_url"))) {
                throw new ServiceException("网络异常,请重试");
            }
            //获取兑换码
            String cdKey = request.getParameter("cdKey");
            if (StringUtils.isNotEmpty(cdKey)) {
                //根据兑换码查询奖品
                UserLottery userLottery = userLotteryMapper.findUserLottery(cdKey);
                userLottery.setUlStatus("1");
                userLotteryMapper.updateByPrimaryKeySelective(userLottery);
            }
            Map result = new HashMap();
            result.put("code_url", resultMap.get("code_url"));//支付地址
            result.put("total_fee", money);//总金额
            result.put("out_trade_no", out_trade_no);//订单号
            Order order = new Order();
            order.setOrderId(out_trade_no);
            order.setOrderProductId(productId);
            order.setOrderSize(productSize);
            order.setOrderEmployeeId(employeeId);
            order.setOrderMoney(money);
            order.setOrderNum(num);
            order.setOrderPoint(point);
            order.setOrderSpecId(specId);
            order.setOrderTransactionId("");
            order.setOrderIsChujiu("0");
            order.setOrderStatus("0");
            order.setOrderCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setOrderPaytime("");
            int i = orderMapper.insertSelective(order);
            if (i <= 0) {
                throw new ServiceException("网络异常,请重试");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public String notifyOrder(HttpServletRequest request) throws ServiceException {
        StringBuilder xmlStr = new StringBuilder("<xml>");
        String responseResult = "";
        Element rootElt = null;
        try {
            SAXReader sr = new SAXReader();
            Document doc = sr.read(request.getInputStream());
            rootElt = doc.getRootElement(); // 获取根节点
        } catch (Exception e) {
            responseResult = fail(xmlStr);
        }
        String return_code = rootElt.elementTextTrim("return_code");
        System.out.println("微信回调返回" + return_code + "=======================================");
        if (return_code.equalsIgnoreCase("SUCCESS")) {
            //更新订单表
            String out_trade_no = rootElt.elementTextTrim("out_trade_no");  //订单号
            String result_code = rootElt.elementTextTrim("result_code");    //业务结果
            String transaction_id = rootElt.elementTextTrim("transaction_id");//微信商户订单号
            System.err.println("获取到的微信订单号" + transaction_id);
            System.out.println("订单号：" + out_trade_no + ",订单情况:" + result_code);
            Order order = orderMapper.selectByPrimaryKey(out_trade_no);
            if (order == null) {
                responseResult = fail(xmlStr);
            }
            if (order.getOrderStatus().equals("1")) {
                responseResult = success(xmlStr);
            }
            order.setOrderStatus("1");
            order.setOrderPaytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setOrderId(out_trade_no);
            order.setOrderTransactionId(transaction_id);
            int i = orderMapper.updateByPrimaryKeySelective(order);
            if (i <= 0) {
                responseResult = fail(xmlStr);
            }
            //如果有员工id则表示公众号，需要提成
            if (StringUtils.isEmpty(order.getOrderEmployeeId())) {
                String orderMoney = order.getOrderMoney();
                //获取员工信息
                LevelUser employee = levelUserMapper.findEmployeeById(order.getOrderEmployeeId());
                if(employee != null){
                    //修改用户金额
                    updateUserFc(employee,orderMoney);
                    //终端店的
                    LevelUser levelUser1 = levelUserMapper.selectParent(employee.getLevelUserParentOpenid());
                    if(levelUser1 != null){
                        //修改用户金额
                        updateUserFc(levelUser1,orderMoney);
                        //城市合作伙伴的
                        LevelUser levelUser2 = levelUserMapper.selectParent(levelUser1.getLevelUserParentOpenid());
                        if(levelUser2 != null){
                            //修改用户金额
                            updateUserFc(levelUser2,orderMoney);
                            //城市创始人的
                            LevelUser levelUser3 = levelUserMapper.selectParent(levelUser2.getLevelUserParentOpenid());
                            if(levelUser3 != null){
                                updateUserFc(levelUser3,orderMoney);
                            }
                        }
                    }
                }
            }
            responseResult = success(xmlStr);
        } else {
            responseResult = fail(xmlStr);
        }
        return responseResult;
    }

    /**
     * 微信提现
     * @param request
     * @return
     */
    @Override
    public void tixian(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if(StringUtils.isEmpty(userId)){
            throw new ServiceException("用户id不允许为空");
        }
        LevelUser levelUser = levelUserMapper.selectByPrimaryKey(userId);
        //微信openid
        String openid = levelUser.getLevelUserWxOpenid();
        //随机字符串
        String nonce_str = RandCharsUtils.getRandomString(16);
        IdWorker idWorker = new IdWorker();
        //商户订单号
        String partner_trade_no = System.currentTimeMillis()+"";
        System.err.println("商户订单号为："+partner_trade_no);
        //提现金额
        String money = request.getParameter("money");
        if(StringUtils.isEmpty(money)){
            throw new ServiceException("金额不允许为空");
        }
        Integer totalMoney = Integer.valueOf(money)*100;
        if(totalMoney < 1){
            throw new ServiceException("提现金额不允许小于1元");
        }
        if(Double.valueOf(levelUser.getLevelUserMoney()) < Double.valueOf(money)){
            throw new ServiceException("余额不足！");
        }

        String desc = "啤小生提现";
        //ip
        String spbill_create_ip = WeixinPayUtil.getIpAddress();
        //参数：开始生成签名
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("mch_appid", Param.APPID);
        parameters.put("mchid", Param.mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("partner_trade_no", partner_trade_no);
        parameters.put("openid", openid);
        parameters.put("check_name", "NO_CHECK");
        parameters.put("spbill_create_ip", spbill_create_ip);
        parameters.put("amount", totalMoney);
        parameters.put("desc", desc);
        //第一次签名
        String sign = WXSignUtils.createSign("UTF-8", parameters);
        parameters.put("sign",sign);
        //构造xml参数
        String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
        try {
            CloseableHttpResponse response =  HttpUtils.Post("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers", xmlInfo, true);
            String transfersXml = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("返回的xml为："+transfersXml);
            Map<String, String> transferMap = HttpXmlUtils.parseRefundXml(transfersXml);
            if (transferMap.size()>0) {
                if (transferMap.get("result_code").equals("SUCCESS") && transferMap.get("return_code").equals("SUCCESS")) {
                    //成功需要进行的逻辑操作，
                    Tixian tixian = new Tixian();
                    tixian.setTxId(partner_trade_no);
                    tixian.setTxMoney(money);
                    tixian.setTxUserid(levelUser.getLevelUserId());
                    tixian.setTxSuccessTime(DateUtil.getCurrentTimeS2());
                    tixianMapper.insertSelective(tixian);
                    levelUser.setLevelUserMoney(Double.valueOf(levelUser.getLevelUserMoney())-Double.valueOf(money)+"");
                    levelUserMapper.updateByPrimaryKeySelective(levelUser);
                }else{
                    throw new ServiceException("提现失败");
                }
            }
            System.out.println("成功");
        } catch (Exception e) {
            throw new ServiceException("企业付款异常：" + e.getMessage());
        }
    }

    /**
     * 失败返回xml
     *
     * @param xmlStr
     * @return
     */
    public String fail(StringBuilder xmlStr) {
        xmlStr.append("<return_code>");
        xmlStr.append("FAIL");
        xmlStr.append("</return_code>");
        xmlStr.append("<return_msg>");
        xmlStr.append("return_code is not SUCCESS");
        xmlStr.append("</return_msg>");
        xmlStr.append("</xml>");
        return xmlStr.toString();
    }

    /**
     * 成功返回xml
     *
     * @param xmlStr
     * @return
     */
    public String success(StringBuilder xmlStr) {
        xmlStr.append("<return_code>");
        xmlStr.append("SUCCESS");
        xmlStr.append("</return_code>");
        xmlStr.append("<return_msg>");
        xmlStr.append("OK");
        xmlStr.append("</return_msg>");
        xmlStr.append("</xml>");
        return xmlStr.toString();
    }

    public void updateUserFc(LevelUser levelUser,String orderMoney){
        DecimalFormat df = new DecimalFormat("######0");
        //获取用户分成比例
        LevelFc levelFc1 = levelFcMapper.selectByLevelId(levelUser.getLevelUserLevel());
        //用户当前金额
        Double money1 = Double.valueOf(levelUser.getLevelUserMoney());
        double v1 = money1 + Double.valueOf(orderMoney) * Double.valueOf(levelFc1.getFcBili());
        //修改员工金额
        levelUser.setLevelUserMoney(df.format(v1) + "");
        levelUserMapper.updateByPrimaryKeySelective(levelUser);
    }

}
