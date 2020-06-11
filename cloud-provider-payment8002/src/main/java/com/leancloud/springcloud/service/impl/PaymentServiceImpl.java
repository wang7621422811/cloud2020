package com.leancloud.springcloud.service.impl;

import com.leancloud.springcloud.dao.PaymentDao;
import com.leancloud.springcloud.entities.Payment;
import com.leancloud.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: weibin
 * @create: 2020/5/28 15:46
 * @update: 2020/5/28 15:46
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao dao;

    @Override
    public int insert(Payment payment) {
        return dao.insert(payment);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(Payment payment) {
        return dao.update(payment);
    }

    @Override
    public Payment findByiId(int id) {
        return dao.load(id);
    }
}
