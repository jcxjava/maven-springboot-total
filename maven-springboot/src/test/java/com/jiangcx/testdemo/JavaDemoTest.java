package com.jiangcx.testdemo;

import com.jiangcx.entity.Student;
import org.junit.Test;

import javax.xml.soap.Node;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by jiangcx on 2019/3/14
 * Iterator 迭代器的使用
 */

public class JavaDemoTest {
    @Test
    public void testTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(
                Calendar.DAY_OF_MONTH),00,00,00);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        new Date().getTime();
        System.out.println("--------------");
        System.out.println("max:"+LocalDateTime.now().with(LocalTime.MAX));
        System.out.println("min:"+LocalDateTime.now().with(LocalTime.MIN));
    }

    @Test
    public void testArray(){
        String[] arr = new String[]{"1",null,";k;"};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
        Map map = new HashMap();
        map.put(null,"jljl");
        map.put("key","value");
        System.out.println(map);

        Node node = null;

    }

    public static void main(String[] args){
        Student student = new Student();

        new Student();
        new Student().toString();
        student = null;
        System.gc();

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("被回收了");
    }

    @Test
    public void testIterator(){
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add(4);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        String[] strArr = new String[]{"1","2","3","4","5"};
        Map<String,Object> map = new HashMap<>();
        map.put("name","jcx");
        map.put("stu",list);
        map.put("age",100);
        //map的遍历 key的遍历
        Set keySet = map.keySet();
        Iterator keyIt = keySet.iterator();
        while (keyIt.hasNext()){
            System.out.println(keyIt.next());
        }
        System.out.println("----------------------------------");
        //map的遍历 value 的遍历
        for(Object o : map.values()){
            System.out.println(o);
        }
    }
    @Test
    public void test(){
        String url = "http://www.baidu.com/live800?aa=123";
        try {
            url = URLEncoder.encode(url,"utf-8");
            System.out.println(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
