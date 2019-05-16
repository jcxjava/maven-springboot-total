package com.jiangcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 声明Eureka启动类。EureakServer服务器端启动类，接受其它微服务注册进来
public class Eureka8000App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8000App.class, args);
    }

}
