package com.leancloud.springcloud.controller;

import com.leancloud.springcloud.entities.CommonResult;
import com.leancloud.springcloud.entities.Payment;
import com.leancloud.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @auther: weibin
 * @create: 2020/5/28 15:50
 * @update: 2020/5/28 15:50
 */
@Api("支付相关接口")
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    // 服务器发现
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    /**
     * [新增]
     * @author weibin
     * @date 2020/05/28
     **/
    @ApiOperation("新增支付订单")
    @PostMapping
    public CommonResult insert(Payment payment){
        paymentService.insert(payment);
        log.info("保存成功");
        System.out.println("8001");
        return new CommonResult(200,"保存成功");
    }

    /**
     * [刪除]
     * @author weibin
     * @date 2020/05/28
     **/
    @ApiOperation("根据ID删除订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "支付订单的id",required = true)
    })
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable  int id){
         paymentService.delete(id);
         log.info("测试是否重启");
        return new CommonResult(200,"删除成功");
    }

    /**
     * [更新]
     * @author weibin
     * @date 2020/05/28
     **/
    @ApiOperation("更新订单")
    @PutMapping
    public CommonResult update(Payment payment){
         paymentService.update(payment);
        return new CommonResult(200,"修改成功");
    }

    /**
     * [查询] 根据主键 id 查询
     * @author weibin
     * @date 2020/05/28
     **/
    @ApiOperation("根据ID查询单个订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "支付订单的id",required = true)
    })
    @GetMapping("/get/{id}")
    public CommonResult load(@PathVariable  int id){
        Payment payment = paymentService.findByiId(id);
        System.out.println("8001");
        return new CommonResult(200,"查询成功",payment);
    }

    /**
     * 2.
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("****element : " + service);
        }
        // 一个微服务下的所有实现
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
