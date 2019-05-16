package com.jiangcx.pojo;

import com.alibaba.fastjson.JSON;

import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private int age;
    private String sex;


    /**
     * 重写student对象的equals（）方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex);
    }

    /**
     * 重写该对象的hashCode（）方法。
     * @return
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, sex);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
