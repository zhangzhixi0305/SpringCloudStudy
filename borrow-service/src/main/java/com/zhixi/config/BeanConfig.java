package com.zhixi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName BeanConfig
 * @Author zhangzhixi
 * @Description 注册bean实例
 * @Date 2022-5-31 19:31
 * @Version 1.0
 */
@LoadBalancerClient(value = "userservice",      //指定为 userservice 服务，只要是调用此服务都会使用我们指定的策略
        configuration = LoadBalancedConfig.class)   //指定我们刚刚定义好的配置类
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced  // 负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
