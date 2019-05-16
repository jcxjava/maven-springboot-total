package com.jiangcx.pojo;

public class SyncBean {

    public synchronized void reduce(){
        int count = 5;
        for(int i = 0; i< 5; i++){
            try {
                count--;
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"————"+count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
