package com.leancloud.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages = {"com.leancloud.springcloud"})
@MapperScan("com.leancloud.springcloud.dao") // 扫描dao
@EnableEurekaClient // 表明为Eureka的客户端
@EnableDiscoveryClient // 1. 开启服务发现
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }


}
