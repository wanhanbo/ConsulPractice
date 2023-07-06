package com.wan.order.service;


import com.wan.feign.clients.UserClient;
import com.wan.feign.pojo.User;
import com.wan.order.mapper.OrderMapper;
import com.wan.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.利用RestTemplate发送http请求，查询用户
        User user=userClient.queryById(order.getUserId());
        //3.封装user到order
        order.setUser(user);

        // 4.返回
        return order;
    }
}
