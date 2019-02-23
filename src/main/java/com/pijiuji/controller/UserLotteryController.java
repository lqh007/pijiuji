package com.pijiuji.controller;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.UserLotteryService;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("userLottery")
public class UserLotteryController {

    @Autowired
    private UserLotteryService userLotteryService;

    /**
     * 输入优惠码
     * @return
     */
    @RequestMapping("writeCdkey")
    @ResponseBody
    public ResponseResult<Map<String,String>> writeCdkey(HttpServletRequest request){
        ResponseResult<Map<String,String>> result;
        try{
            Map<String,String> map = userLotteryService.writeCdkey(request);
            result = new ResponseResult<>(200,"执行成功",map);
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

    /**
     * 点击出酒后执行的接口
     * 修改兑换码状态并生成订单
     * @return
     */
    @RequestMapping("updateCdkey")
    @ResponseBody
    public ResponseResult<Void> updateCdkey(HttpServletRequest request){
        ResponseResult<Void> result;
        try{
            userLotteryService.updateCdkey(request);
            result = new ResponseResult<Void>(200,"执行成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;

    }
}
