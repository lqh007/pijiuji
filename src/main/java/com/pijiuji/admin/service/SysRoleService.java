package com.pijiuji.admin.service;

import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface SysRoleService {
    /**
     * 添加角色
     * @param request
     * @return
     */
    ResponseResult saveSysRole(HttpServletRequest request);

    /**
     * 查询所有角色
     * @param request
     * @return
     */
    ResponseResult findSysRole(HttpServletRequest request);

    /**
     * 查询角色拥有的菜单权限
     * @param request
     * @return
     */
    ResponseResult selectSysRolePermis(HttpServletRequest request);

    /**
     * 修改角色权限
     * @param request
     * @return
     */
    ResponseResult updateSysRole(HttpServletRequest request);
}
