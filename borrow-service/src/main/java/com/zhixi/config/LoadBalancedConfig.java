package com.zhixi.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @ClassName LoadBalancedConfig
 * @Author zhangzhixi
 * @Description Eureka负载均衡-随机策略
 * @Date 2022-6-1 7:51
 * @Version 1.0
 */
public class LoadBalancedConfig {
    /**
     * 将官方提供的 RandomLoadBalancer 注册为Bean
     *
     * @param environment               环境变量
     * @param loadBalancerClientFactory 客户端工厂
     * @return RandomLoadBalancer
     */
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }
}
