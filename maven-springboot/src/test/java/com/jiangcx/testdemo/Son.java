package com.jiangcx.testdemo;

/**
 * Created by jiangcx on 2019/3/27
 */
public class Son extends Father {
    public Son(String ss) {
        super(ss);
    }

    public static void main(String[] args){
        new Son("ok");
        System.out.println("123");
    }

}
