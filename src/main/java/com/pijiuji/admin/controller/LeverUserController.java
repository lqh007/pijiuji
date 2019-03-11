package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.LeverUserService;
import com.pijiuji.bean.LevelUser;
import com.pijiuji.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("leverUser")
public class LeverUserController {
    @Autowired
    private LeverUserService leverUserService;

    /**
     * 后台登录
     * @param request
     * @return
     */
    @PostMapping("login")
    public ResponseResult login(HttpServletRequest request){
        return leverUserService.login(request);
    }

    /**
     * 0城市创始人  1城市合作伙伴 2终端店  3服务推广员
     * 查询后台列表
     */

    @GetMapping("findLeverUserByStatus")
    public ResponseResult findLeverUserByStatus(HttpServletRequest request){
        return leverUserService.findLeverUserByStatus(request);
    }

    /**
     * 0城市创始人  1城市合作伙伴 2终端店  3服务推广员
     * 搜索后台用户列表
     */

    @RequestMapping("searchUserByStatus")
    public ResponseResult searchUserByStatus(HttpServletRequest request){
        return leverUserService.searchUserByStatus(request);
    }

    /**
     * 审核用户
     */
    @PostMapping("updatelevelUserApplyStatus")
    public ResponseResult updatelevelUserApplyStatus(HttpServletRequest request){
        return leverUserService.updatelevelUserApplyStatus(request);
    }
    /**
     * 禁用用户
     */
    @PostMapping("updatelevelUserStatus")
    public ResponseResult updatelevelUserStatus(LevelUser levelUser){
        return leverUserService.updatelevelUserStatus(levelUser);
    }

    public ResponseResult searchLevelUser(@RequestParam Map param){
        return leverUserService.searchLevelUser(param);
    }
}
