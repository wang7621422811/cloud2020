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
 *  响应规定格式类
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /** 状态码 */
    @ApiModelProperty(name = "状态码")
    private Integer code;
    /** 返回消息 */
    @ApiModelProperty(name = "返回消息")
    private String msg;
    /** 返回的数据 */
    @ApiModelProperty(name = "返回的数据")
    private T data;

    public CommonResult(Integer code, String msg) {
        this(code,msg,null);
    }
}
