package com.jiangcx.threadPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Threadpoo{
    public void test(){
        // 创建一个大小固定为3 的线程池子
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 创建10个线程，交给线程池执行
        for(int i=0;i<10;i++){
            Runnable runn = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"线程开始执行操作");
                    try {
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread()+"执行任务完毕");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            pool.execute(runn);
            System.out.println("将任务派给"+i+"线程处理");
        }
        pool.shutdown();
        System.out.println("所有的线程执行任务完毕");
    }

    public static void main(String[] args){
        new Threadpoo().test();
    }
}
