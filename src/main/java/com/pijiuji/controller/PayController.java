package com.pijiuji.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.github.wxpay.sdk.WXPayUtil;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.WeixinPayService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weixin")
public class PayController {

    private static final Logger LOG = Logger.getLogger(PayController.class);
    private static final String ORDER_PAY_QUERY = "https://api.mch.weixin.qq.com/pay/orderquery"; // 支付订单查询
    @Autowired
    private WeixinPayService weixinPayService;

    /**
     * 生成二维码
     *
     * @return
     */
    @RequestMapping("/createNative")
    public ResponseResult<Map<String,String>> createNative(HttpServletRequest request) {
        ResponseResult<Map<String,String>> result = null;
        try{
            IdWorker idworker = new IdWorker();
            Map<String,String> map = weixinPayService.createNative(idworker.nextId() + "", request);
            result = new ResponseResult<>(200,"生成成功",map);
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

    /**
     * 微信提现
     *
     * @return
     */
    @RequestMapping("/tixian")
    public ResponseResult<Void> tixian(HttpServletRequest request) {
        ResponseResult<Void> result = null;
        try{
            weixinPayService.tixian(request);
            result = new ResponseResult<>(200,"提现成功，24小时内到帐");
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

    /**
     * 微信回调地址
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("notifyOrder")
    public String notifyOrder(HttpServletRequest request) {
        System.err.println("进入回调地址");
        String result = weixinPayService.notifyOrder(request);
        System.err.println("返回的结果为："+result);
        return result;
    }

    /**
     * 查询支付结果
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/pay/query", method = RequestMethod.POST)
    public void orderPayQuery(HttpServletRequest request, HttpServletResponse response) {
        String tradeno = request.getParameter("tradeno");
        LOG.info("[/order/pay/query]");
        if (StringUtil.isEmpty(tradeno)) {
            WebUtil.response(response, WebUtil.packJsonp("", JSON
                    .toJSONString(new ResponseResult<>(500, "订单号不能为空"))));
        }
        Map<String, Object> restmap = null;
        try {
            Map<String, Object> parm = new HashMap<String, Object>();
            parm.put("appid", Param.APPID);
            parm.put("mch_id", Param.mch_id);
            parm.put("out_trade_no", tradeno);
            parm.put("nonce_str", WXPayUtil.generateNonceStr());
            parm.put("sign", PayUtil.getSign(parm, Param.key));

            String restxml = HttpUtils.post(ORDER_PAY_QUERY, XmlUtil.xmlFormat(parm, false));
            restmap = XmlUtil.xmlParse(restxml);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("return_code")) && "SUCCESS".equalsIgnoreCase(restmap.get("result_code").toString())) {
            String message = restmap.get("trade_state_desc").toString();
            // 订单查询成功 处理业务逻辑
            LOG.info("订单查询：订单" + restmap.get("out_trade_no") + "支付成功");
            String trade_state = restmap.get("trade_state").toString();
            Integer state = 0;
            if ("SUCCESS".equalsIgnoreCase(trade_state)) {
                trade_state = "支付成功";
                state = 200;
            }else if("REFUND".equalsIgnoreCase(trade_state)) {
                trade_state = "转入退款";
                state = 250;
            }else if("NOTPAY".equalsIgnoreCase(trade_state)) {
                trade_state = "订单未支付";
                state = 300;
            }else if("CLOSED".equalsIgnoreCase(trade_state)) {
                trade_state = "订单已关闭";
                state = 350;
            }else if("REVOKED".equalsIgnoreCase(trade_state)) {
                trade_state = "取消支付";
                state = 400;
            }else if("USERPAYING".equalsIgnoreCase(trade_state)) {
                trade_state = "用户支付中";
                state = 450;
            }else if("PAYERROR".equalsIgnoreCase(trade_state)) {
                trade_state = "支付失败";
                state = 500;
            }
            WebUtil.response(response, WebUtil.packJsonp("", JSON
                    .toJSONString(new ResponseResult<>(state,trade_state))));
        } else {
//            String message = restmap.get("trade_state_desc").toString();
//            if (CollectionUtil.isNotEmpty(restmap)) {
//                LOG.info("订单支付失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
//            }
            WebUtil.response(response, WebUtil.packJsonp("", JSON
                    .toJSONString(new ResponseResult(300, "订单支付失败"))));
        }
    }

}
