package com.jiangcx.testDemo;


import com.jiangcx.pojo.SyncBean;

/**
 * 测试多线程操作同一个被锁住的方法。
 */
public class TestSyncWithPOJO {
    public static SyncBean syncBean = new SyncBean();
    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncBean.reduce();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncBean.reduce();
            }
        });

        thread1.start();
        thread2.start();
    }
}
