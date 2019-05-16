package com.jiangcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by jiangcx on 2019/3/12
 * 启动类，忽略
 */
@SpringBootApplication
@MapperScan("com.jiangcx.mapper")
@EnableCaching //开启redis缓存
//@EnableScheduling //定时任务启动注解
public class StartApp {
    public static void main(String[] args){
        SpringApplication.run(StartApp.class, args);
    }
}
