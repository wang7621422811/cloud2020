package com.leancloud.springcloud.controller;

import com.leancloud.springcloud.entities.CommonResult;
import com.leancloud.springcloud.entities.Payment;
import com.leancloud.springcloud.lb.LoadBalancer;
import com.leancloud.springcloud.lb.MyLb;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @auther: weibin
 * @create: 2020/5/28 16:37
 * @update: 2020/5/28 16:37
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    /**
     * http://CLOUD-PAYMENT-SERVICE : 微服务的名称
     */
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private DiscoveryClient discoveryClient;  //获取所有的服务
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        // 根据微服务名称获取单个微服务的集合
        List<ServiceInstance> allService = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (allService.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instace(allService);
        String url = serviceInstance.getUri() + "/payment/payment/lb";
        return restTemplate.getForObject(url,String.class);
    }

    @PostMapping("/payment")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);

    }

    @GetMapping("/payment/{id}")
    public CommonResult findPayment(@PathVariable int id) {
        System.out.println("查询");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }




}
