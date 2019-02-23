package com.pijiuji.admin.service;

import com.pijiuji.bean.LevelUser;
import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LeverUserService {
    /**
     * 后台登录带权限
     * @param request
     * @return
     */
    ResponseResult login(HttpServletRequest request);

    /** 0城市创始人  1城市合作伙伴 2终端店  3服务推广员
     *查询后台用户列表
     * @param request
     * @return
     */
    ResponseResult findLeverUserByStatus(HttpServletRequest request);

    /**
     * 审核用户
     * @param request
     * @return
     */
    ResponseResult updatelevelUserApplyStatus(HttpServletRequest request);

    /**
     * 禁用账户
     * @param levelUser
     * @return
     */
    ResponseResult updatelevelUserStatus(LevelUser levelUser);

    /**
     * 搜索用户
     * @param param
     * @return
     */
    ResponseResult searchLevelUser(Map param);
}
