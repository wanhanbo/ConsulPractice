package com.wan.user.service;


import com.wan.feign.clients.OrderClient;
import com.wan.feign.clients.OrderHystrixClient1;
import com.wan.feign.clients.OrderHystrixClient2;
import com.wan.feign.pojo.Order;
import com.wan.user.mapper.UserMapper;
import com.wan.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /* 改用下面两个
    @Resource
    private OrderClient orderClient;*/

    @Resource
    private OrderHystrixClient1 orderHystrixClient1;

    @Resource
    private OrderHystrixClient2 orderHystrixClient2;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }

    public List<Order> queryAllOrdersById(Long id) {
        return orderHystrixClient1.queryOrderByUserId(id);
    }

    public Long querySumPrice(Long id){
        return orderHystrixClient2.queryPriceByUserId(id);
    }
}