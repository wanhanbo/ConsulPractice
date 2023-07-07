package com.wan.feign.clients;

import com.wan.feign.fallback.OrderFallback;
import com.wan.feign.fallback.OrderFallbackFactory;
import com.wan.feign.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "orderservice",fallbackFactory = OrderFallbackFactory.class,contextId = "OrderHystrixClient2")
@Component
public interface OrderHystrixClient2 {
    @GetMapping("order/price/user/{userId}")
    public Long queryPriceByUserId(@PathVariable("userId") Long userId);
}
