package com.jiangcx.service.impl;

import com.jiangcx.dao.TeacherDao;
import com.jiangcx.entity.Teacher;
import com.jiangcx.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by jiangcx on 2019/5/14
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public Teacher getTeacherBySno(String sno) {
        Teacher teacher = teacherDao.queryTeacherByTno(sno);
        return teacher;
    }

    @Override
    public int insert(Teacher teacher) {
        int count = teacherDao.insert(teacher);
        return count;
    }
}
