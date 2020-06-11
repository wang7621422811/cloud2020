package com.leancloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther: weibin
 * @create: 2020/6/1 16:21
 * @update: 2020/6/1 16:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class,args);
    }

}
