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
import org.springframework.web.bind.annotation.*;

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
        System.out.println("8002");
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
    @GetMapping("/{id}")
    public CommonResult load(@PathVariable  int id){
        Payment payment = paymentService.findByiId(id);
        System.out.println("8002");
        return new CommonResult(200,"查询成功",payment);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
