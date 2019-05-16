package com.jiangcx.service.impl;

import com.jiangcx.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by jiangcx on 2019/3/11
 */
@Service("service1")
public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String name) {
        System.out.println("this is HelloServiceImpl======="+name);
    }
}
