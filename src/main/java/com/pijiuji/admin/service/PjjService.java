package com.pijiuji.admin.service;

import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface PjjService {

    /**
     * 为啤酒机分配啤酒
     * @param request
     * @return
     */
    ResponseResult allocation(HttpServletRequest request);

    /**
     * 查询啤酒机列表
     * @param request
     * @return
     */
    ResponseResult findAdminAllPjj(HttpServletRequest request);

    /**
     * 查询啤酒机上的所展示的商品
     * @param request
     * @return
     */
    ResponseResult product(HttpServletRequest request);

    /**
     * 增加啤酒机
     * @param request
     * @return
     */
    ResponseResult savePjj(HttpServletRequest request);

    /**
     * 给用户分配啤酒机
     * @param request
     * @return
     */
    ResponseResult updatePjj(HttpServletRequest request);

    /**
     * 查询全部啤酒机
     * @param request
     * @return
     */
    ResponseResult findPjj(HttpServletRequest request);

    /**
     * 分配啤酒机
     * @param request
     * @return
     */
    ResponseResult searchPjj(HttpServletRequest request);
}
