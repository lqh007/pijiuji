package com.pijiuji.admin.service;

import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    /**
     * 查询所有订单
     * @param request
     * @return
     */
    ResponseResult findAllOrder(HttpServletRequest request);
}
