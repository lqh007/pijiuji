package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.OrderService;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.LevelUserMapper;
import com.pijiuji.mapper.OrderMapper;
import com.pijiuji.mapper.ProductMapper;
import com.pijiuji.util.Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private LevelUserMapper levelUserMapper;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseResult findAllOrder(HttpServletRequest request) {

        String page = request.getParameter("page");
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria();
        List<Order> orders = orderMapper.selectByExample(orderExample);
        for (int i = 0; i < orders.size(); i++) {
            String orderStatus = orders.get(i).getOrderStatus();
            if ("0".equals(orderStatus)) {
                orders.get(i).setOrderStatus("未支付");
            }else if ("1".equals(orderStatus)) {
                orders.get(i).setOrderStatus("已支付");
            }
            String orderIsChujiu = orders.get(i).getOrderIsChujiu();
            if ("0".equals(orderIsChujiu)) {
                orders.get(i).setOrderIsChujiu("未出酒");
            }else if ("1".equals(orderIsChujiu)) {
                orders.get(i).setOrderIsChujiu("已出酒");
            }
            String orderEmployeeId = orders.get(i).getOrderEmployeeId();
            if (StringUtils.isEmpty(orderEmployeeId)) {
                orders.get(i).setOrderEmployeeId("无");
            }else {
                LevelUser levelUser = levelUserMapper.selectByPrimaryKey(orderEmployeeId);
                if (levelUser != null) {
                    orders.get(i).setOrderEmployeeId(levelUser.getLevelUserName());
                }else {
                    orders.get(i).setOrderEmployeeId("无姓名");
                }
            }
            String orderProductId = orders.get(i).getOrderProductId();
            if (StringUtils.isEmpty(orderProductId)) {
                orders.get(i).setOrderProductId("无");
            }else {
                Product product = productMapper.selectByPrimaryKey(orderProductId);
                orders.get(i).setOrderProductId(product.getProductName());
            }
            String orderNum = orders.get(i).getOrderNum();
            if (StringUtils.isEmpty(orderNum)) {
                orders.get(i).setOrderNum("1");
            }
            String orderPoint = orders.get(i).getOrderPoint();
            if (StringUtils.isEmpty(orderPoint)) {
                orders.get(i).setOrderPoint("不是外部订单");
            }
        }
        PageInfo pageInfo = new PageInfo(orders);
        return new ResponseResult(200,"查询成功",pageInfo);
    }
}
