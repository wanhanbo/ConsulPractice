package com.wan.user.service;


import com.wan.feign.clients.OrderClient;
import com.wan.feign.pojo.Order;
import com.wan.user.mapper.UserMapper;
import com.wan.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private OrderClient orderClient;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }

    public List<Order> queryAllOrdersById(Long id) {
        return orderClient.queryOrderByUserId(id);
    }

    public Long querySumPrice(Long id){
        return orderClient.queryPriceByUserId(id);
    }
}