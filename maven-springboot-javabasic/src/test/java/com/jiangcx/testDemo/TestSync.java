package com.jiangcx.testDemo;


import com.jiangcx.pojo.SyncBean;
import org.junit.Before;
import org.junit.Test;

/**
 * 通过此例子说明，junit不能测试多线程。这是junit的一个不足之处。
 */

public class TestSync {
    public SyncBean syncBean = null;

    @Before
    public void init(){
        syncBean = new SyncBean();
    }
    @Test
    public void test(){
        System.out.println("hello");
        syncBean = new SyncBean();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
                //syncBean.reduce();
            }
        });
        //t1.start();
        t2.start();
    }
    public static void main(String[] args){
        /*final SyncBean syncBean = new SyncBean();
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
        thread2.start();*/
        System.out.println("htool");
    }



}
