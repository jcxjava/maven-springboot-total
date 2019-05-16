package com.jiangcx.service.impl;

import com.jiangcx.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by jiangcx on 2019/3/11
 */
@Service("service2")
public class HelloServiceImpl22 implements HelloService {
    @Override
    public void say(String name) {
        System.out.println("this is HelloServiceImpl22........."+name);
    }
}
