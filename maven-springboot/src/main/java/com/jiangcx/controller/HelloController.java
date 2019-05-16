package com.jiangcx.controller;

import com.jiangcx.service.HelloService;
import com.jiangcx.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jiangcx on 2019/3/6
 */
@RestController
public class HelloController {

    @Autowired
    @Qualifier("service2") //接口若有多个实现类，依赖注入的时候用 @Qualifier 标注绑定具体某个实现类
    private HelloService helloService;

    @Autowired
    private HelloServiceImpl helloServiceimpl;

    @RequestMapping("/hello/{name}/test/{age}")
    public String sayHello(@PathVariable String name,@PathVariable String age){
        helloService.say(name);
        helloServiceimpl.say(name);
        System.out.println("age="+age);
        return "Hello Spring Boot";
    }

    @RequestMapping("/check")
    public String urlParamCheck(@RequestParam String name,@RequestParam String age){
        System.out.println("name="+name+",age="+age);
        return "success,name="+name+",age="+age;
    }


}
