package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.PjjService;
import com.pijiuji.bean.Pjj;
import com.pijiuji.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("pjj")
public class PjjController {

    @Autowired
    private PjjService pjjService;

    /**
     * 查询啤酒机
     * @param request
     * @return
     */
    @GetMapping("findAdminAllPjj")
    public ResponseResult findAdminAllPjj(HttpServletRequest request){
        return pjjService.findAdminAllPjj(request);
    }
    /**
     * 查询啤酒机上展示的商品
     * @param request
     * @return
     */
    @RequestMapping("/product")
    public ResponseResult product(HttpServletRequest request){
        return pjjService.product(request);
    }

    /**
     * 机器分配啤酒
     * @param request
     * @return
     */
    @RequestMapping("/allocation")
    public ResponseResult allocation(HttpServletRequest request){
        return pjjService.allocation(request);
    }

    /**
     * 添加啤酒机
     */
    @PostMapping("savePjj")
    public ResponseResult savePjj(HttpServletRequest request){
        return pjjService.savePjj(request);
    }

    /**
     * 分配啤酒机给用户
     */
    @PostMapping("updatePjj")
    public ResponseResult updatePjj(HttpServletRequest request){
        return pjjService.updatePjj(request);
    }

    /**
     * 查询全部用户
     */
    @GetMapping("findPjj")
    public ResponseResult findPjj(HttpServletRequest request){
        return pjjService.findPjj(request);
    }

}
