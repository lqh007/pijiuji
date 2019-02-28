package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.SysRoleService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    /**
     * 添加角色
     * @param request
     * @return
     */
    @PostMapping("saveSysRole")
    public ResponseResult saveSysRole(HttpServletRequest request){
        return sysRoleService.saveSysRole(request);
    }

    /**
     * 查询角色列表
     */
    @GetMapping("findSysRole")
    public ResponseResult findSysRole(HttpServletRequest request){
        return sysRoleService.findSysRole(request);
    }

    /**
     * 为角色修改权限
     */
    @PostMapping("updateSysRole")
    @ResponseBody
    public ResponseResult updateSysRole(HttpServletRequest request){
        return sysRoleService.updateSysRole(request);
    }

    /**
     * 查询角色拥有的权限
     */
    @PostMapping("selectSysRolePermis")
    @ResponseBody
    public ResponseResult selectSysRolePermis(HttpServletRequest request){
        return sysRoleService.selectSysRolePermis(request);
    }



}
