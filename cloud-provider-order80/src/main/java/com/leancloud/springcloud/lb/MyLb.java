package com.leancloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: weibin
 * @create: 2020/6/11 15:50
 * @update: 2020/6/11 15:50
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取当前应该执行的次数
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("**next : " + next);
        return next;
    }

    @Override
    public ServiceInstance instace(List<ServiceInstance> serviceInstances) {
        // index = 当前执行的次数 % 所有的服务
        int index = getAndIncrement() % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
