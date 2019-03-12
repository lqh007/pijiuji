package com.pijiuji.admin.service;

import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface OrderService {
    /**
     * 查询所有订单
     * @param request
     * @return
     */
    ResponseResult findAllOrder(HttpServletRequest request);

    /**
     * 订单查询
     * @param request
     * @return
     */
    ResponseResult searchOrder(HttpServletRequest request);

    /**
     * 订单金额按月份统计
     * @return
     */
    ResponseResult<Map<String, Object>> orderAmount();
}
