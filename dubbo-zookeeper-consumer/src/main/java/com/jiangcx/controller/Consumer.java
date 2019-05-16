package com.jiangcx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jiangcx.service.DubboService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Consumer {
    //这里必须用 dubbo 的 @Reference 注解
    @Reference
    private DubboService dubboService;

    @RequestMapping("/getInfo/{name}")
    public Map getInfo(@PathVariable String name){
        Map<String, Object> map = new HashMap<>();
        String res = dubboService.getData(name);
        map.put("success",res);
        System.out.println("result:" + res + ",调用成功！！！！！！！！");
        return map;
    }

}
