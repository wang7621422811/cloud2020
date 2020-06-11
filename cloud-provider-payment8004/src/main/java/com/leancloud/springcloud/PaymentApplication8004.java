package com.leancloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.zookeeper.ConditionalOnZookeeperEnabled;

/**
 * @auther: weibin
 * @create: 2020/6/1 15:06
 * @update: 2020/6/1 15:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
