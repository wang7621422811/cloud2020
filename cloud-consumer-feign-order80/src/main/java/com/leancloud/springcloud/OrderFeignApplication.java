package com.leancloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther: weibin
 * @create: 2020/6/12 15:26
 * @update: 2020/6/12 15:26
 */
@SpringBootApplication
@EnableFeignClients // 开启Feign的支持
public class OrderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication.class,args);
    }
}
