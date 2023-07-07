package com.wan.feign.fallback;

import com.wan.feign.clients.OrderHystrixClient2;
import com.wan.feign.pojo.Order;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class OrderFallbackFactory implements FallbackFactory<OrderHystrixClient2> {
    @Override
    public OrderHystrixClient2 create(Throwable throwable) {
        return new OrderHystrixClient2() {
            @Override
            public Long queryPriceByUserId(Long userId) {
                System.out.println("=====queryPriceByUserId方法熔断实现===");
                return -1L;
            }
        };
    }
}
