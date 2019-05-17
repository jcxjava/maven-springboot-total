package com.jiangcx.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jiangcx on 2019/5/15
 */
@Configuration
public class ConfigUtils {

    @Bean
    @LoadBalanced // Ribbon 负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
