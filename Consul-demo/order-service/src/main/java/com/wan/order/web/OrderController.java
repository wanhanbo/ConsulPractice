package com.wan.order.web;


import com.wan.order.pojo.Order;
import com.wan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderById(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("user/{userId}")
    public List<Order> queryOrderByUserId(@PathVariable("userId") Long userId) {
        // 根据userid查询所有订单并返回
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return orderService.queryOrderByUserId(userId);
    }

    @GetMapping("price/{orderId}")
    public Long queryPriceById(@PathVariable("orderId") Long orderId) {
        // 根据orderId查询金额
        return orderService.queryPriceById(orderId);
    }

    @GetMapping("price/user/{userId}")
    public Long queryPriceByUserId(@PathVariable("userId") Long userId) {
        // 根据UserId查询总金额
        /**
         * For JMter Test
        try{
            Thread.sleep(500);
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
        int i=1/0;
        return orderService.queryPriceByUserId(userId);
    }


    @GetMapping("all")
    // 查询所有订单并返回
    public List<Order>findAllOrders(){
        return orderService.findAllOrders();
    }


}
