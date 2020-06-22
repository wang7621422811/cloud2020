package com.leancloud.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义Gateway-Filter
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    /**
     * 实现过滤条件
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("**************come in MyLogGatewayFilter : " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            System.out.println("用户名为Null,非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 放行,进入到下一个过过滤链
        return chain.filter(exchange);
    }

    /**
     *  返回数值越小,加载的优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
