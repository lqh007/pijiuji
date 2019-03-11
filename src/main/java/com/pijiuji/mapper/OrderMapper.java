package com.pijiuji.mapper;

import com.pijiuji.bean.Order;
import com.pijiuji.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> searchOrder(@Param("orderId") String orderId,@Param("orderStatus") String orderStatus,@Param("startTime") String startTime,@Param("endTime") String endTime);

    List<Order> selectAll();

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    List<Map<String, String>> selectTongji(@Param("userOpenid") String userOpenid,@Param("time") String time);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}