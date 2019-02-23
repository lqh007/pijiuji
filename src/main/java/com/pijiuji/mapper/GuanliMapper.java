package com.pijiuji.mapper;

import com.pijiuji.bean.Order;

import java.util.List;
import java.util.Map;

public interface GuanliMapper {
    String findSystemcode(String systemCode);

    List<Map<String,String>> findOrderById(Map result);

    int updateOrder(Order order);

}
