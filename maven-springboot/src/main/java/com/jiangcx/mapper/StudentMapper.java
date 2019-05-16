package com.jiangcx.mapper;

import com.jiangcx.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jiangcx on 2019/3/12
 */
public interface StudentMapper {
    @Select("select * from student")
    @Results({
          @Result(property = "sno",column = "sno"),
          @Result(property = "sname",column = "sname"),
          @Result(property = "ssex",column = "ssex"),
          @Result(property = "sbirthday",column = "sbirthday"),
          @Result(property = "classes",column = "class"),
    })
    List<Student> getAllStu();


    @Select("select * from student where sno = #{sno}")
    @Results({
            @Result(property = "sno",column = "sno"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "ssex",column = "ssex"),
            @Result(property = "sbirthday",column = "sbirthday"),
            @Result(property = "classes",column = "class"),
    })
    Student getOneStu(String sno);

    @Insert("insert into student values (#{sno},#{sname},#{ssex},#{sbirthday},#{classes})")
    void insertStu(Student student);

    @Update("update student set sname = #{sname},ssex = #{ssex} where sno = #{sno}")
    void updateStu(Student student);
}
