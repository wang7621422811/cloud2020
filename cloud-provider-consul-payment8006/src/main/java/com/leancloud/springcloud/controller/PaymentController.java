package com.leancloud.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther: weibin
 * @create: 2020/6/1 15:07
 * @update: 2020/6/1 15:07
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentZk() {
        return "com.leancloud.springcloud with consul: "+serverPort + UUID.randomUUID();
    }




}
