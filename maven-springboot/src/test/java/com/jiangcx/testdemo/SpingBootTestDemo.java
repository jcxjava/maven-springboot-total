package com.jiangcx.testdemo;


import com.jiangcx.MavenSpringbootApplicationTests;
import com.jiangcx.entity.Student;
import com.jiangcx.mapper.StudentMapper;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jiangcx on 2019/3/12
 */
public class SpingBootTestDemo extends MavenSpringbootApplicationTests{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SpingBootTestDemo.class);

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testQueryAllStu(){
        LOGGER.info(" query begin.....................");
        List<Student> list = studentMapper.getAllStu();
        for(Student stu : list){
            System.out.println(stu.toString());
        }
        LOGGER.info(" query over.....................");
    }

    @Test
    public void insertStu(){
        Student student = new Student();
        student.setSno("666");
        student.setSname("com/jiangcx");
        student.setSbirthday("1998-1-1");
        student.setSsex("男");
        student.setClasses("95033");
        studentMapper.insertStu(student);
        System.out.println(studentMapper.getOneStu("666").toString());
    }
    @Test
    public void updateStu(){
        Student student = studentMapper.getOneStu("666");
        student.setSname("jcxjcx");
        studentMapper.updateStu(student);
    }
}
