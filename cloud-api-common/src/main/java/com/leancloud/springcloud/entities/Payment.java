package com.leancloud.springcloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: weibin
 * @create: 2020/5/28 15:21
 * @update: 2020/5/28 15:21
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    /** id */
    @ApiModelProperty(name = "id")
    private  Long id;
    /** 订单号*/
    @ApiModelProperty(name = "订单号")
    private String serial;
}
