package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pijiuji.admin.service.SysPermissionService;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.SysPermissionMapper;
import com.pijiuji.mapper.SysRolePermissionMapper;
import com.pijiuji.util.Param;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 查询权限列表
     * @param request
     * @return
     */
    @Override
    public ResponseResult findAll(HttpServletRequest request) {
        String page = request.getParameter("page");

        Integer integer = Integer.valueOf(page);
        PageHelper.startPage(integer, Param.pageSize);
        SysPermissionExample sysPermissionExample = new SysPermissionExample();
        sysPermissionExample.createCriteria();
        List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(sysPermissionExample);
        PageInfo pageInfo = new PageInfo(sysPermissions);
        System.out.println(pageInfo.toString());
        List list = pageInfo.getList();
        System.out.println(list.toString());
        return new ResponseResult(200,"查询成功",pageInfo);
    }

    @Override
    public ResponseResult saveSysPermission(SysPermission sysPermission) {
        if (StringUtils.isEmpty(sysPermission.getName())) {
            return new ResponseResult(500,"名称不能为空");
        }
        int i = sysPermissionMapper.insertSelective(sysPermission);
        if (i > 0){
            return new ResponseResult(200,"增加成功");
        }
        return new ResponseResult(500,"增加失败");
    }

    @Override
    public ResponseResult findSysPermissionAll(HttpServletRequest request) {
        SysPermissionExample sysPermissionExample = new SysPermissionExample();
        sysPermissionExample.createCriteria();
        List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(sysPermissionExample);
        return new ResponseResult(200,"查询成功",sysPermissions);
    }

    @Override
    public ResponseResult updtaeSysPermission(SysPermission sysPermission) {
        if (sysPermission.getId() == null) {
            return new ResponseResult(500,"id不能为空");
        }
        int i = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        if (i > 0) {
            return  new ResponseResult(200,"修改成功");
        }
        return new ResponseResult(500,"修改失败");
    }

    @Override
    public ResponseResult deleteSysPerssion(Integer id) {
        if (id == null) {
            return new ResponseResult(500,"id不能为空");
        }
        int i = sysPermissionMapper.deleteByPrimaryKey(id);
        SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
        SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();
        criteria.andSysRoleIdEqualTo(id);
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
        if (sysRolePermissions.size() > 0 && sysRolePermissions != null) {
             sysRolePermissionMapper.deleteByExample(sysRolePermissionExample);
        }

        if (i > 0) {
            return new ResponseResult(200,"删除成功");
        }
        return new ResponseResult(500,"删除失败");
    }
}
