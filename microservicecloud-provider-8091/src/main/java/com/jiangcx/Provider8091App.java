package com.jiangcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.jiangcx.dao")
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class Provider8091App {

    public static void main(String[] args) {
        SpringApplication.run(Provider8091App.class, args);
    }

}
