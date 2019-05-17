package com.jiangcx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka8002App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8002App.class, args);
    }

}
