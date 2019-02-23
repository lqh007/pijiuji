package com.pijiuji.admin.service;



import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.SysPermission;

import javax.servlet.http.HttpServletRequest;

public interface SysPermissionService {
    /**
     * 查询所有菜单
     * @param request
     * @return
     */
    ResponseResult findAll(HttpServletRequest request);

    /**
     * 增加菜单
     * @param sysPermission
     * @return
     */
    ResponseResult saveSysPermission(SysPermission sysPermission);

    /**
     * 查询所有的菜单
     * @param request
     * @return
     */
    ResponseResult findSysPermissionAll(HttpServletRequest request);

    /**
     * 修改菜单
     * @param sysPermission
     * @return
     */
    ResponseResult updtaeSysPermission(SysPermission sysPermission);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    ResponseResult deleteSysPerssion(Integer id);
}
