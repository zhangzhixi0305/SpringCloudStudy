package com.zhixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName BorrowApplication
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 17:36
 * @Version 1.0
 */
@EnableHystrix // 服务降级
@EnableFeignClients  // 实现更加便捷的服务调用
@EnableEurekaClient  // 开启Eureka客户端-能够被注册到微服务中去
@SpringBootApplication
public class BorrowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class, args);
    }
}
