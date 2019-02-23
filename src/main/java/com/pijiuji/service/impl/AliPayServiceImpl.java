package com.pijiuji.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.pijiuji.bean.LevelFc;
import com.pijiuji.bean.LevelUser;
import com.pijiuji.bean.Order;
import com.pijiuji.bean.UserLottery;
import com.pijiuji.mapper.LevelFcMapper;
import com.pijiuji.mapper.LevelUserMapper;
import com.pijiuji.mapper.OrderMapper;
import com.pijiuji.mapper.UserLotteryMapper;
import com.pijiuji.service.AliPayService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.IdWorker;
import com.pijiuji.util.Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private LevelFcMapper levelFcMapper;
    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserLotteryMapper userLotteryMapper;

    @Override
    public Map<String,String> aliPay(HttpServletRequest request) {
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
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(Param.PAYWAYURL, Param.ALIPAYAPPID, Param.PRIVATEKAY, "json", "UTF-8", Param.PUBLICKEY, "RSA2");
        //设置请求参数
        //   AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        AlipayTradePrecreateRequest alipayRequest = new AlipayTradePrecreateRequest();
        alipayRequest.setNotifyUrl(Param.ALIPAYNOTIFYURL);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        //付款金额，必填
        String total_amount = request.getParameter("money");
//        total_amount = "0.01";
        //订单名称，必填
        String subject = "皮小生_支付";
        String body = "啤小生_啤酒订单";
        //商品描述，可空
        IdWorker idworker = new IdWorker();
        long l = idworker.nextId();
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setBody(body);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setOutTradeNo(l+"");
        // model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setStoreId("2088331495722581");
        model.setTimeoutExpress("30m");
        alipayRequest.setBizModel(model);
        //请求
        String result = null;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            throw new ServiceException(e.getMessage());
        }
        String replace = result.replace("\\/", "/");
        Map<String,Object> map = (Map<String,Object>)JSONObject.parse(replace);
        Map<String,String> response = (Map<String,String>)map.get("alipay_trade_precreate_response");
        if(!response.get("msg").equalsIgnoreCase("Success")){
            throw new ServiceException("信息错误，生成二维码失败");
        }
        //获取兑换码
        String cdKey = request.getParameter("cdKey");
        if (StringUtils.isNotEmpty(cdKey)) {
            //根据兑换码查询奖品
            UserLottery userLottery = userLotteryMapper.findUserLottery(cdKey);
            userLottery.setUlStatus("1");
            userLotteryMapper.updateByPrimaryKeySelective(userLottery);
        }
        Order order = new Order();
        order.setOrderId(l+"");
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
        Map<String,String> res = new HashMap<>();
        res.put("out_trade_no",l+"");
        res.put("code_url",response.get("qr_code"));
        res.put("total_fee",total_amount);
        return res;
    }

    /**
     * 支付宝回调
     * @param request
     * @return
     */
    @Override
    public String notify(HttpServletRequest request) {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            System.err.println("key:"+name+",value:"+ Arrays.toString(values));
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean flag = false;
        try {
            flag = AlipaySignature.rsaCheckV1(params, Param.PUBLICKEY, "utf-8", "RSA2");
        } catch (AlipayApiException e) {
            throw new ServiceException("验签失败");
        }
        if (flag == false) {
            return "error";
        }
        //更新订单表
        String out_trade_no = request.getParameter("out_trade_no");  //订单号
        String trade_no = request.getParameter("trade_no");//微信商户订单号
        System.err.println("获取到的支付宝订单号" + trade_no);
        System.out.println("订单号：" + out_trade_no);
        Order order = orderMapper.selectByPrimaryKey(out_trade_no);
        if (order == null) {
            return "error";
        }
        if (order.getOrderStatus().equals("1")) {
            return "success";
        }
        order.setOrderStatus("1");
        order.setOrderPaytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        order.setOrderId(out_trade_no);
        order.setOrderTransactionId(trade_no);
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            return "error";
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
        return "success";
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
