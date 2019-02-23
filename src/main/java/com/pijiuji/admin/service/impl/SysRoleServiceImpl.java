package com.pijiuji.admin.service.impl;

import com.pijiuji.admin.service.SysRoleService;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.SysPermissionMapper;
import com.pijiuji.mapper.SysRoleMapper;
import com.pijiuji.mapper.SysRolePermissionMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Override
    public ResponseResult saveSysRole(HttpServletRequest request) {
        String roleName = request.getParameter("roleName");
        String permissionIds = request.getParameter("permissionIds");
        SysRole sysRole = new SysRole();
        sysRole.setName(roleName);
        int i = sysRoleMapper.insertSelective(sysRole);
        String[] permiss = permissionIds.split(",");
        SysRolePermission sysRolePermission = new SysRolePermission();
        int i1 = 0;
        for (String permissionId : permiss) {
            sysRolePermission.setSysRoleId(sysRole.getId());
            sysRolePermission.setSysPermissionId(Integer.valueOf(permissionId));
            i1 += sysRolePermissionMapper.insertSelective(sysRolePermission);
        }
        if (i > 0 && i1 >0 ) {
            return new ResponseResult(200,"添加成功");
        }
        return new ResponseResult(500,"添加失败");
    }

    /**
     * 查询角色列表
     * @param request
     * @return
     */
    @Override
    public ResponseResult findSysRole(HttpServletRequest request) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria();
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        return new ResponseResult(200,"查询成功",sysRoles);
    }

    @Override
    public ResponseResult updateSysRole(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        if (StringUtils.isEmpty(roleId)) {
            return new ResponseResult(500,"角色id不能为空");
        }
        SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
        SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();
       criteria.andSysRoleIdEqualTo(Integer.valueOf(roleId));
        int i = sysRolePermissionMapper.deleteByExample(sysRolePermissionExample);

        if (i >0) {
            String permissionIds = request.getParameter("permissionIds");
            String[] split = permissionIds.split(",");
            for (String permissionId : split) {
                SysRolePermission sysRolePermission = new SysRolePermission();
                sysRolePermission.setSysRoleId(Integer.valueOf(roleId));
                sysRolePermission.setSysPermissionId(Integer.valueOf(permissionId));
                sysRolePermissionMapper.insertSelective(sysRolePermission);
            }
            SysRolePermissionExample sysRolePermissionExample1 = new SysRolePermissionExample();
            SysRolePermissionExample.Criteria criteria1 = sysRolePermissionExample1.createCriteria();
            criteria1.andSysRoleIdEqualTo(Integer.valueOf(roleId));
            List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample1);
            if (sysRolePermissions.size() <= 0) {
                return new ResponseResult(500, "该角色没有任何权限");
            }
            List<SysPermission> sysPermissions = new ArrayList<>();
            for (SysRolePermission sysRolePermission : sysRolePermissions) {
                Integer sysPermissionId = sysRolePermission.getSysPermissionId();
                SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(sysPermissionId);
                sysPermissions.add(sysPermission);
            }

            return new ResponseResult(200,"修改成功",sysPermissions);
        }else  {
            return new ResponseResult(500,"修改失败");
        }
    }
}
