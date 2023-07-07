package com.wan.user.web;


import com.wan.feign.pojo.Order;
import com.wan.user.pojo.User;

import com.wan.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
    /**
     * 路径： /user/110
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("/{id}/orders")
    /** 查询{id}的所有订单*/
    public List<Order> queryAllOrdersById(@PathVariable("id") Long id) {
        System.out.println(Thread.currentThread().getName()+"=====queryAllOrdersById()===");
        return userService.queryAllOrdersById(id);
    }

    @GetMapping("/{id}/price")
    /** 查询{id}订单总价*/
    public Long querySumPrice(@PathVariable("id") Long id) {
        System.out.println(Thread.currentThread().getName()+"=====querySumPrice()===");
        return userService.querySumPrice(id);
    }


}
