package com.jiangcx.threadPractice;

/**
 * Created by jiangcx on 2019/5/14
 * 多线程死锁：线程A 和 线程B 互相等待对方持有的锁，导致线程死锁
 */
public class DeadLocal {
    //定义两把锁
    public static Object lockA = new Object();
    public static Object lockB = new Object();

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("Thread A 得到锁 lockA");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB){
                        System.out.println("Thread A 得到锁 lockB");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("Thread B 得到锁 lockB");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA){
                        System.out.println("Thread B 得到锁 lockA");
                    }
                }
            }
        }.start();

    }
}
