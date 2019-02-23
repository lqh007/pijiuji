package com.pijiuji.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface WeixinPayService {

    /**
     * 生成微信支付二维码
     * @param out_trade_no 订单号
     * @param request 金额(分)
     * @return
     */
    public Map createNative(String out_trade_no, HttpServletRequest request);

    /**
     * 微信回调地址
     * @param request
     * @return
     */
    String notifyOrder(HttpServletRequest request);

    /**
     * 微信提现
     * @param request
     * @return
     */
    void tixian(HttpServletRequest request);
}
