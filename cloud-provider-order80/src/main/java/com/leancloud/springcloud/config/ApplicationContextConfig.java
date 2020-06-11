package com.leancloud.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: weibin
 * @create: 2020/5/28 16:50
 * @update: 2020/5/28 16:50
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用@LoadBalanced 生效负载均衡机制
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
