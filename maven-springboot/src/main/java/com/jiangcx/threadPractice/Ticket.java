package com.jiangcx.threadPractice;

/**
 * 模拟多窗口火车抢票，多线程与锁
 */
public class Ticket implements Runnable {
    private int num = 100;//票的数量，票号码

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num <= 0) {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出票序列号：" + num);
                num--;
            }
        }
    }


}
