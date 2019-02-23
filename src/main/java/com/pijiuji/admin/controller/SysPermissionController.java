package com.pijiuji.admin.controller;



import com.pijiuji.admin.service.SysPermissionService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("SysPermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 查询菜单
     * @param request
     * @return
     */
    @GetMapping("findSysPermission")
    @ResponseBody
    public ResponseResult findSysPermission(HttpServletRequest request){
        return sysPermissionService.findAll(request);
    }

    /**
     * 查询所有菜单
     * @param request
     * @return
     */
    @GetMapping("findSysPermissionAll")
    @ResponseBody
    public ResponseResult findSysPermissionAll(HttpServletRequest request){
        return sysPermissionService.findSysPermissionAll(request);
    }

    /**
     * 添加菜单
     */
    @PostMapping("saveSysPermission")
    @ResponseBody
    public ResponseResult saveSysPermission(SysPermission sysPermission){
        return sysPermissionService.saveSysPermission(sysPermission);
    }
    /**
     * 修改菜单
     */
    @PostMapping("updtaeSysPermission")
    @ResponseBody
    public ResponseResult updtaeSysPermission(SysPermission sysPermission){
        return sysPermissionService.updtaeSysPermission(sysPermission);
    }
    /**
     * 删除菜单
     */
    @PostMapping("deleteSysPersion")
    @ResponseBody
    public ResponseResult deleteSysPersion(Integer id){
        return sysPermissionService.deleteSysPerssion(id);
    }
}
