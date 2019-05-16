package com.jiangcx.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jiangcx.service.DubboService;

@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public String getData(String name) {
        return "hello:"+name;
    }
}
