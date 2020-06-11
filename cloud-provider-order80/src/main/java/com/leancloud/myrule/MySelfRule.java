package com.leancloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: weibin
 * @create: 2020/6/2 12:13
 * @update: 2020/6/2 12:13
 *  自定义负载均衡规则包
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
