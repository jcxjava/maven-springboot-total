package com.jiangcx.controller;

import com.jiangcx.entity.Teacher;
import com.jiangcx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by jiangcx on 2019/5/14
 */
@RestController
public class MybatisController {

    @Resource
    private TeacherService teacherService;


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
    @RequestMapping("getTeacher/{sno}") // 804、825、831、856
    public Teacher getInfo(@PathVariable String sno){
        return  teacherService.getTeacherBySno(sno);
    }
}
