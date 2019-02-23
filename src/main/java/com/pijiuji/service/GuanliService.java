package com.pijiuji.service;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.UserPjj;

import javax.servlet.http.HttpServletRequest;


public interface GuanliService {
    ResponseResult goGuan(String systemCode);

    ResponseResult findOrderByEmployee(String employeeId);

    /**
     * 修改啤酒机的地址
     * @param request
     */
    void updateAddress(HttpServletRequest request);

    String updateOrder(HttpServletRequest request);

    ResponseResult findSurplus(String pjjId);

    ResponseResult updatePjj(UserPjj userPjj);

    /**
     * 恢复气容量
     * @param request
     */
    void updateQi(HttpServletRequest request);
}
