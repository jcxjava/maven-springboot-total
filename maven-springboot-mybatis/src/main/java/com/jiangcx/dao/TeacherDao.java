package com.jiangcx.dao;

import com.jiangcx.entity.Teacher;

/**
 * Created by jiangcx on 2019/5/14
 */
public interface TeacherDao {

    int insert(Teacher teacher);

    Teacher queryTeacherByTno(String tno);


}
