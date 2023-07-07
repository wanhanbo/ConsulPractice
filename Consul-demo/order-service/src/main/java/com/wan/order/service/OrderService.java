package com.wan.order.service;


import com.wan.feign.clients.UserClient;
import com.wan.feign.pojo.User;
import com.wan.order.mapper.OrderMapper;
import com.wan.order.pojo.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

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

    public List<Order> queryOrderByUserId(Long userId){
        List<Order> orderList=orderMapper.findByUserId(userId);
        return orderList;
    }

    public Long queryPriceById( Long orderId){
        return orderMapper.priceById(orderId);
    }
    public Long queryPriceByUserId(Long userId){
        return orderMapper.priceByUserId(userId);
    }


    public List<Order> findAllOrders(){
        List<Order> orderList=orderMapper.findALLOrders();
        for(Order order:orderList){
            User user=userClient.queryById(order.getUserId());
            //3.封装user到order
            order.setUser(user);
        }
        return orderList;
    }


}
