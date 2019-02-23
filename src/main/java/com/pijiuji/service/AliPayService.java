package com.pijiuji.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AliPayService {
    /**
     * 支付宝支付
     * @param request
     * @return
     */
    Map<String,String> aliPay(HttpServletRequest request);

    /**
     * 支付宝回调
     * @param request
     * @return
     */
    String notify(HttpServletRequest request);
}
