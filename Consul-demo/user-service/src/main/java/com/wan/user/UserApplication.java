package com.wan.user;

import com.wan.feign.clients.OrderClient;
import com.wan.feign.clients.UserClient;
import com.wan.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.wan.user.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {OrderClient.class},defaultConfiguration = DefaultFeignConfiguration.class)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
