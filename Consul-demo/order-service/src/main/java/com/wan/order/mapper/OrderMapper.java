package com.wan.order.mapper;


import com.wan.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);

    @Select("select * from tb_order where user_id=#{userId}")
    List<Order> findByUserId(Long userId);

    @Select("select price from tb_order where id=#{id}")
    Long priceById(Long orderId);

    @Select("select sum(price) from tb_order where user_id=#{userId}")
    Long priceByUserId(Long userId);

    @Select("select * from tb_order")
    List<Order> findALLOrders();
}
