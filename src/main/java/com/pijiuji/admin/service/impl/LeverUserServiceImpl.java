package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.LeverUserService;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.LevelUserMapper;
import com.pijiuji.mapper.SysPermissionMapper;
import com.pijiuji.mapper.SysRoleMapper;
import com.pijiuji.mapper.SysRolePermissionMapper;
import com.pijiuji.util.MD5Util;
import com.pijiuji.util.Param;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeverUserServiceImpl implements LeverUserService {
    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public ResponseResult login(HttpServletRequest request) {
        String levelUserPhone = request.getParameter("levelUserPhone");
        String levelUserPassword = request.getParameter("levelUserPassword");
        if (StringUtils.isEmpty(levelUserPhone)) {
            return new ResponseResult(500, "登录手机号不能为空");
        }
        if (StringUtils.isEmpty(levelUserPassword)) {
            return new ResponseResult(500, "密码不能为空");
        }
        LevelUserExample levelUserExample = new LevelUserExample();
        LevelUserExample.Criteria criteria = levelUserExample.createCriteria();
        criteria.andLevelUserPasswordEqualTo(MD5Util.MD5Encode(levelUserPassword));
        criteria.andLevelUserPhoneEqualTo(levelUserPhone);
        List<LevelUser> levelUsers = levelUserMapper.selectByExample(levelUserExample);
        if (levelUsers.size() <= 0) {
            return new ResponseResult(500, "没有这个用户");
        }
        LevelUser levelUser = levelUsers.get(0);
        String levelUserApplyStatus = levelUser.getLevelUserApplyStatus();
        if ("0".equals(levelUserApplyStatus) || "2".equals(levelUserApplyStatus)) {
            return new ResponseResult(500, "您的账号还未审核通过");
        }
        String levelUserStatus = levelUser.getLevelUserStatus();
        if ("1".equals(levelUserStatus)) {
            return new ResponseResult(500, "您的账号已被禁用");
        }
        Integer leverRoleId = levelUser.getLevelRoleId();
        if (leverRoleId == null) {
            return new ResponseResult(500, "当前用户没有角色");
        }
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(leverRoleId);
        if (sysRole == null) {
            return new ResponseResult(500, "没有这个角色");
        }
        Integer id = sysRole.getId();
        SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
        SysRolePermissionExample.Criteria criteria1 = sysRolePermissionExample.createCriteria();
        criteria1.andSysRoleIdEqualTo(id);
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
        if (sysRolePermissions.size() <= 0) {
            return new ResponseResult(500, "该角色没有任何权限");
        }
        List<SysPermission> sysPermissions = new ArrayList<>();
        for (SysRolePermission sysRolePermission : sysRolePermissions) {
            Integer sysPermissionId = sysRolePermission.getSysPermissionId();
            SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(sysPermissionId);
            sysPermissions.add(sysPermission);
        }
        String levelUserId = levelUser.getLevelUserId();
        HashMap<String, Object> map = new HashMap<>();
        map.put("menu",sysPermissions);
        map.put("userId",levelUserId);
        return new ResponseResult(200, "登录成功", map);
    }

    /**
     * 查询后台用户列表
     *
     * @param request 0城市创始人  1城市合作伙伴 2终端店  3服务推广员
     * @return
     */
    @Override
    public ResponseResult findLeverUserByStatus(HttpServletRequest request) {
        String levelUserLevel = request.getParameter("levelUserLevel");
        if (StringUtils.isEmpty(levelUserLevel)) {
            return new ResponseResult(500, "级别不能为空");
        }
        String page = request.getParameter("page");
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        LevelUserExample levelUserExample = new LevelUserExample();
        LevelUserExample.Criteria criteria = levelUserExample.createCriteria();
        criteria.andLevelUserLevelEqualTo(levelUserLevel);
        List<LevelUser> levelUsers = levelUserMapper.selectByExample(levelUserExample);
        PageInfo pageInfo = replaceLevelUsers(levelUsers);

        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 审核用户
     *
     * @param request
     * @return
     */
    @Override
    public ResponseResult updatelevelUserApplyStatus(HttpServletRequest request) {
        String levelUserApplyStatus = request.getParameter("levelUserApplyStatus");
        String levelUserId = request.getParameter("levelUserId");
        String levelUserReason = request.getParameter("levelUserReason");
        LevelUser levelUser = new LevelUser();
        if (StringUtils.isEmpty(levelUserId)) {
            return new ResponseResult(500, "用户id不能为空");
        }
        //证明是审核通过
        if ("1".equals(levelUserApplyStatus)) {
            String levelUserLevel = request.getParameter("levelUserLevel");
            if (StringUtils.isEmpty(levelUserLevel)) {
                return new ResponseResult(500, "级别不允许为空");
            }
            if (levelUserLevel.equals("城市创始人")) {
                levelUserLevel = "0";
            } else if (levelUserLevel.equals("合作伙伴")) {
                levelUserLevel = "1";
            } else if (levelUserLevel.equals("终端店")) {
                levelUserLevel = "2";
            } else if (levelUserLevel.equals("服务推广员")) {
                levelUserLevel = "3";
            }
            int level = Integer.valueOf(levelUserLevel) + 2;
            levelUser.setLevelUserApplyStatus(levelUserApplyStatus);
            levelUser.setLevelUserId(levelUserId);
            levelUser.setLevelRoleId(level);
            levelUser.setLevelUserPassword(MD5Util.MD5Encode("123456"));
            int i = levelUserMapper.updateByPrimaryKeySelective(levelUser);
            if (i > 0) {
                return new ResponseResult(200, "审核成功");
            }
            return new ResponseResult(500, "服务器异常");

        } else {
            if (StringUtils.isEmpty(levelUserReason)) {
                return new ResponseResult(500, "审核原因不能为空");
            }
            levelUser.setLevelUserId(levelUserId);
            levelUser.setLevelUserApplyStatus(levelUserApplyStatus);
            levelUser.setLevelUserReason(levelUserReason);
            int i = levelUserMapper.updateByPrimaryKeySelective(levelUser);
            if (i > 0) {
                return new ResponseResult(200, "审核成功");
            }
            return new ResponseResult(500, "服务器异常");

        }

    }

    @Override
    public ResponseResult updatelevelUserStatus(LevelUser levelUser) {
        if (StringUtils.isEmpty(levelUser.getLevelUserId())) {
            return new ResponseResult(500, "userId不能为空");
        }
        if (StringUtils.isEmpty(levelUser.getLevelUserStatus())) {
            return new ResponseResult(500, "审核状态不能为空");
        }
        int i = levelUserMapper.updateByPrimaryKeySelective(levelUser);
        if (i > 0) {
            return new ResponseResult(200, "修改成功");
        }
        return new ResponseResult(500, "修改失败");
    }

    @Override
    public ResponseResult searchLevelUser(Map param) {
        String page = param.get("page").toString();
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        //查询搜索数据
        List<LevelUser> levelUsers = levelUserMapper.searchLevelUser(param);
        PageInfo pageInfo = replaceLevelUsers(levelUsers);
        return new ResponseResult(200, "查询成功", pageInfo);
    }


    public PageInfo replaceLevelUsers(List<LevelUser> levelUsers) {
        for (int i = 0; i < levelUsers.size(); i++) {
            levelUsers.get(i).setLevelUserParentOpenid(null);
            String levelUserApplyStatus = levelUsers.get(i).getLevelUserApplyStatus();
            String levelUserLevel = levelUsers.get(i).getLevelUserLevel();
            if ("0".equals(levelUserApplyStatus)) {
                levelUsers.get(i).setLevelUserApplyStatus("审核中");
                levelUsers.get(i).setLevelUserWxOpenid("0");
            } else if ("1".equals(levelUserApplyStatus)) {
                levelUsers.get(i).setLevelUserApplyStatus("通过");
                levelUsers.get(i).setLevelUserWxOpenid("1");
            } else if ("2".equals(levelUserApplyStatus)) {
                levelUsers.get(i).setLevelUserApplyStatus("失败");
                levelUsers.get(i).setLevelUserWxOpenid("2");
            }
            String levelUserStatus = levelUsers.get(i).getLevelUserStatus();
            if ("0".equals(levelUserStatus)) {
                levelUsers.get(i).setLevelUserStatus("正常");
                levelUsers.get(i).setLevelUserPassword("0");
            } else if ("1".equals(levelUserStatus)) {
                levelUsers.get(i).setLevelUserStatus("禁用");
                levelUsers.get(i).setLevelUserPassword("1");
            }
            if ("0".equals(levelUserLevel)) {
                levelUsers.get(i).setLevelUserLevel("城市创始人");
            } else if ("1".equals(levelUserLevel)) {
                levelUsers.get(i).setLevelUserLevel("合作伙伴");
            } else if ("2".equals(levelUserLevel)) {
                levelUsers.get(i).setLevelUserLevel("终端店");
            } else if ("3".equals(levelUserLevel)) {
                levelUsers.get(i).setLevelUserLevel("服务推广员");
            }
        }


        PageInfo pageInfo = new PageInfo(levelUsers);
        return pageInfo;
    }


}
