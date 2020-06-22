package com.leancloud.springcloud.service;

import com.leancloud.springcloud.entities.CommonResult;
import com.leancloud.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * value = CLOUD-PAYMENT-SERVICE 就是服务提供者的服务名称,指定调用哪个微服务上的接口
 * @PathVariable("id") int id 一定要指定 ("id")名称
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 根据主键 id 查询
     */
    @GetMapping("/payment/{id}")
    CommonResult load(@PathVariable("id") int id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
