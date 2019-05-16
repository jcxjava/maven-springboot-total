package com.jiangcx.testDemo;


import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法题
 */
public class TestCalculation {
    /**
     * 1、编写一个程序，输入n，求n！（用递归的方式实现）
     */
    @Test
    public void test1(){
        System.out.println(cal(5));
    }
    public long cal(long n){
        if(n==1){
            return 1;
        }else {
            return n*cal(n-1);
        }
    }



    /**
     * 2.编写一个程序，有1，2,3,4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        for (int i=1;i<=4;i++){
            for (int j=1;j<=4;j++){
                for (int k=1;k<=4;k++){
                    if(i!=j && i!=k && j!=k){
                        list.add(i*100+j*10+k);
                    }
                }
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 3、斐波那契数列（用递归的方式实现）
     */
    @Test
    public void test3(){
        int sum = 0;
        for(int i=0;i<10;i++){
            long value = f(i);
            System.out.print(value+" ");
            sum+=f(i);
        }
        System.out.println();
        System.out.println("sum="+sum);
    }

    public long f(int n){
        if(n==0 || n==1){
            return 1;
        }else {
            return f(n-1)+f(n-2);
        }
    }
    /**
     * 4、用递归方法删除文件
     */

    @Test
    public void test4(){
        File dir = new File("G:\\aa");
        del(dir);
        System.out.println("删除完毕！");

    }
    public void del(File dir){
        if(dir.exists() && dir.isDirectory()){
            File[] files = dir.listFiles();
            for(File f : files){
                if(f.isFile()){
                    f.delete();
                }else {
                    del(f);
                }
            }
        }
        dir.delete();
    }
    /**
     * 排序
     */
    @Test
    public void test5(){
        Integer[] arr = new Integer[]{43,345,6,32,65,75,2,67,867,434,5,1,9};
        for(int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.asList(arr));
    }


}
