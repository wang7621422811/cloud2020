package com.leancloud.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *  负载算法的顶级接口
 */
public interface LoadBalancer {

    // 接收一个服务集合,从中选择一个有用的
    ServiceInstance instace(List<ServiceInstance> serviceInstances);
}
