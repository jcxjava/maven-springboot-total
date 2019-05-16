package com.jiangcx.threadPractice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPractice {

    /**
     * 下载图片
     */
    public static void main(String[] args){
        final Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("开始下载图片");
                try {
                    for (int i=0;i<=100;i+=10){
                        System.out.println("已经下载："+i+" %");
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("图片下载完毕！！！");
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("开始查看图片。。。。");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("查看完毕！");
            }
        };

        t1.start();
        t2.start();
    }

}

