package com.wan.feign.clients;

import com.wan.feign.fallback.OrderFallback;
import com.wan.feign.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "orderservice",fallback = OrderFallback.class,contextId = "OrderHystrixClient1")
@Component
public interface OrderHystrixClient1 {
    @GetMapping("order/user/{userId}")
    public List<Order> queryOrderByUserId(@PathVariable("userId") Long userId);
}
