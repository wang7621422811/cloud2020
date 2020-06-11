package com.leancloud.springcloud.conf;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: weibin
 * @create: 2020/6/1 16:22
 * @update: 2020/6/1 16:22
 */
@Configuration
public class ApplicationContext {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
