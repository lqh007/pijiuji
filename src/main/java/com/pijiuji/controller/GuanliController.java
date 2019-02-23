package com.pijiuji.controller;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.UserPjj;
import com.pijiuji.service.GuanliService;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("guanli")
public class GuanliController {

    @Autowired
    private GuanliService guanliService;

    /**
     * 进去管理界面
     * @return
     */
    @PostMapping("goGuan")
    public ResponseResult goGuan(String systemCode){
        return guanliService.goGuan(systemCode);
    }

    /**
     * 查询外部订单
     * @param employeeId
     * @return
     */
    @PostMapping("findOrder")
    public ResponseResult findOrder(String employeeId){
        return guanliService.findOrderByEmployee(employeeId);
    }

    /**
     * 点击出酒
     * @param request
     * @return
     */
    @PostMapping("updateOrder")
    public ResponseResult<String> updateOrder(HttpServletRequest request){
        ResponseResult<String> result = null;
        try{
            String res = guanliService.updateOrder(request);
            result = new ResponseResult<String>(200,"出酒成功",res);
        }catch(ServiceException e){
            result = new ResponseResult<String>(500,e);
        }
        return result;
    }

    /**
     * 设备管理
     * @param pjjId
     * @return
     */
    @PostMapping("findSurplus")
    public ResponseResult findSurplus(String pjjId){
        return guanliService.findSurplus(pjjId);
    }

    /**
     * 修改设备管理
     * @param userPjj
     * @return
     */
    @PostMapping("updateSurplus")
    public ResponseResult updateSurplus(UserPjj userPjj){
        return guanliService.updatePjj(userPjj);
    }

    /**
     * 恢复气容量
     * @param request
     * @return
     */
    @PostMapping("updateQi")
    public ResponseResult updateQi(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            guanliService.updateQi(request);
            result = new ResponseResult<>(200,"恢复成功");
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

    /**
     * 修改啤酒机地址
     * @param request
     * @return
     */
    @PostMapping("updateAddress")
    public ResponseResult updateAddress(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            guanliService.updateAddress(request);
            result = new ResponseResult<>(200,"修改成功");
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

}
