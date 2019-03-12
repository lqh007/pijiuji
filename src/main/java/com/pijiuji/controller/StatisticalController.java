package com.pijiuji.controller;

import com.pijiuji.admin.service.OrderService;
import com.pijiuji.bean.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("statistical")
@Api("统计接口")
public class StatisticalController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orderAmount")
    @ApiOperation("订单金额统计")
    public ResponseResult<Map<String, Object>> orderAmount(){
        return orderService.orderAmount();
    }
}
