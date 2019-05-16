package com.jiangcx.testdemo;


/**
 * Created by jiangcx on 2019/3/27
 */
public interface Inter {
    public static final String aa = "aa";
    public String name = "jcx";
    void set();

    String get();

    public static void main(String[] args){
        System.out.println("hello:"+name);
    }
}
