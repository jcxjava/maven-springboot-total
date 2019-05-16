package com.jiangcx.controller;

import com.jiangcx.entity.Teacher;
import com.jiangcx.service.TeacherService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiangcx on 2019/5/14
 */
@RestController
public class MybatisController {
    @Resource
    private TeacherService teacherService;

    // 暴露一个微服务
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/teacherProvider/discovery")
    public Object discover(){
        List<String> list = discoveryClient.getServices();
        System.out.println("************"+list);
        List<ServiceInstance> srList = discoveryClient.getInstances("MICROSERVICECLOUD-PROVIDER-8091");;
        for(ServiceInstance s : srList){
            System.out.println(s.getServiceId() + "," + s.getHost() + "," + s.getPort()
            + "," + s.getUri());
        }
        return this.discoveryClient;
    }


    @RequestMapping("teacherProvider/{sno}")
    public Teacher getInfo(@PathVariable String sno){
        return  teacherService.getTeacherBySno(sno);
    }

    @RequestMapping("/getInfo")
    public Teacher getTeacherInfo(){
        Teacher teacher = new Teacher();
        teacher.setTno("100");
        teacher.setTsex("男");
        teacher.setTname("jiangcx");
        teacher.setTbirthday("1991-8-8");
        teacher.setProf("教授");
        teacher.setDepart("计算机");
        return teacher;
    }
}
