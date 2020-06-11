package com.leancloud.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther: weibin
 * @create: 2020/5/29 15:24
 * @update: 2020/5/29 15:24
 */
@SpringBootApplication
@EnableEurekaServer // 表明本项目是eureka注册种的的服务端
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
