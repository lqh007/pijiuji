package com.pijiuji.service;

import com.github.pagehelper.PageInfo;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface EmployeeService {

    /**
     * 申请
     * @param request
     * @return
     */
    String applyFor(HttpServletRequest request);

    /**
     * 获取用户信息
     * @param apiConfig
     * @param code
     * @return
     */
    String getUserInfo(ApiConfig apiConfig, String code);

    /**
     * 查询个人中心
     * @param request
     * @return
     */
    Map<String, Object> getUserMessage(HttpServletRequest request);

    /**
     * 查询该用户是否属于4等级里边的
     * @param request
     * @return
     */
    Map<String, String> getUserOpenid(HttpServletRequest request);

    /**
     * 提现列表
     * @param request
     * @return
     */
    PageInfo tixianList(HttpServletRequest request);
}
