package com.wan.feign.clients;


import com.wan.feign.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient("orderservice")
//改用OrderHystrixClient1和OrderHystrixClient2
public interface OrderClient {

    @GetMapping("order/user/{userId}")
    public List<Order> queryOrderByUserId(@PathVariable("userId") Long userId);

    @GetMapping("order/price/user/{userId}")
    public Long queryPriceByUserId(@PathVariable("userId") Long userId);
}
