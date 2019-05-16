package com.jiangcx.testdemo;

/**
 * Created by jiangcx on 2019/3/27
 */
public class Garbage {
    Garbage garbage = null;
    public static void main(String[] args){
        Garbage garbage = new Garbage();
        new Garbage();
        new Garbage().toString();
        garbage = null;
        System.gc();
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行垃圾回收操作");
        garbage = this;
    }
}
