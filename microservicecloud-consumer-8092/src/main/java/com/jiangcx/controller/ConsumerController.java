package com.jiangcx.controller;

import com.jiangcx.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jiangcx on 2019/5/15
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    //private static final String url = "http://localhost:8091/teacherProvider/";
    //通过服务名来调用
    private static final String url = "http://microservicecloud-provider/teacherProvider/";
    @RequestMapping("/getInfo/{sno}") // 804、825、831、856
    public Teacher getInfo(@PathVariable String sno){
        Teacher teacher = restTemplate.getForObject(url + sno, Teacher.class);
        System.out.println("teacher:"+teacher);
        return teacher;
    }

    /**
     * 测试 microservicecloud-provider-8091 向 eureka 注册的服务
     * @return
     */
    @RequestMapping("/getInfo/discovery")
    public Object getDiscoveryInfo(){
        return restTemplate.getForObject(url + "discovery",Object.class);
    }

}
