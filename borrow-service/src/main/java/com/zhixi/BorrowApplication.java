package com.zhixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName BorrowApplication
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 17:36
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class BorrowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class, args);
    }
}
