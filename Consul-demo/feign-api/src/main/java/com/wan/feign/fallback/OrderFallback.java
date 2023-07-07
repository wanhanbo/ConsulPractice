package com.wan.feign.fallback;


import com.wan.feign.clients.OrderHystrixClient1;
import com.wan.feign.pojo.Order;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Component
public class OrderFallback implements OrderHystrixClient1 {
    @Override
    public List<Order> queryOrderByUserId(Long userId) {
        System.out.println("=====queryOrderByUserId方法熔断实现===");

        return Arrays.asList(new Order());
    }


}
