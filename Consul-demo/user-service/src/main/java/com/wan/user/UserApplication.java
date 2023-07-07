package com.wan.user;


import com.wan.feign.clients.OrderHystrixClient1;
import com.wan.feign.clients.OrderHystrixClient2;
import com.wan.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@MapperScan("com.wan.user.mapper")
@SpringBootApplication

@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class,
                    basePackages = {"com.wan.feign.clients"})
//@ComponentScan("com.wan.feign.fallback")
@Import({com.wan.feign.fallback.OrderFallback.class,com.wan.feign.fallback.OrderFallbackFactory.class})
@EnableHystrix
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
