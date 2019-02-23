package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.OrderService;
import com.pijiuji.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("findAllOrder")
    public ResponseResult findAllOrder(HttpServletRequest request){
        return orderService.findAllOrder(request);
    }
}
