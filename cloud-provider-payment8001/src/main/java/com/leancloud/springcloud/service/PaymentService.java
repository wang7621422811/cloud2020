package com.leancloud.springcloud.service;

import com.leancloud.springcloud.entities.Payment;

import java.util.Map;

public interface PaymentService {


    /**
     * 新增
     */
    public int insert(Payment payment);

    /**
     * 删除
     */
    public int delete(int id);

    /**
     * 更新
     */
    public int update(Payment payment);

    /**
     * 根据主键 id 查询
     */
    public Payment findByiId(int id);
}
