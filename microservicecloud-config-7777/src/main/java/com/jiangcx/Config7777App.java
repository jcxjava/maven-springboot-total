package com.jiangcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //springcloud-config配置
public class Config7777App {

    public static void main(String[] args) {
        SpringApplication.run(Config7777App.class, args);
    }

}
