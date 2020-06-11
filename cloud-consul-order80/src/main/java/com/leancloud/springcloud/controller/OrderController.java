package com.leancloud.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: weibin
 * @create: 2020/6/1 16:23
 * @update: 2020/6/1 16:23
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String INVOKER_URL = "http://consul-provider-payment";
    @RequestMapping("/consumer/consul")
    public String getUUID() {
        return restTemplate.getForObject(INVOKER_URL+"/payment/zk",String.class);
    }
}
