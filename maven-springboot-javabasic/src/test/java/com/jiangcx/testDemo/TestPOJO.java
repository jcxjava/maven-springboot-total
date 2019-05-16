package com.jiangcx.testDemo;


import com.alibaba.fastjson.JSONObject;
import com.jiangcx.pojo.Student;
import org.junit.Test;

public class TestPOJO {
    @Test
    public void test(){
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("---------------------");
        System.out.println("aa"=="aa");
        System.out.println("aa".equals("aa"));
    }

    /**
     * 采用 alibaba 的 fastJson
     * Fastjson中的经常调用的方法:
     *
     * 1 public static final Object parse(String text); 　　// 把JSON文本parse为JSONObject或者JSONArray
     * 2 public static final JSONObject parseObject(String text)；　　 // 把JSON文本parse成JSONObject
     * 3 public static final T parseObject(String text, Class clazz); 　　// 把JSON文本parse为JavaBean
     * 4 public static final JSONArray parseArray(String text); 　　// 把JSON文本parse成JSONArray
     * 5 public static final List parseArray(String text, Class clazz); 　　//把JSON文本parse成JavaBean集合
     * 6 public static final String toJSONString(Object object); 　　// 将JavaBean序列化为JSON文本
     * 7 public static final String toJSONString(Object object, boolean prettyFormat); 　　// 将JavaBean序列化为带格式的JSON文本
     * 8 public static final Object toJSON(Object javaObject); 　　//将JavaBean转换为JSONObject或者JSONArray。
     */
    @Test
    public void testJson(){
        Student student = new Student();
        student.setAge(25);
        student.setName("jiangcx");
        student.setSex("boy");
        student.setId(1);
        System.out.println(student);
        JSONObject jsonObject = new JSONObject();

    }

    /**
     * 测试 return  finally
     */
    @Test
    public void testTree(){
        System.out.println(Math.round(878.543));
        int value = getInt("78");
        System.out.println("value="+value);
    }
    public  int getInt(String str){
        int i;
        try {
            i = Integer.valueOf(str);
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            System.out.println("this is finally");
            i = 100;
            return i;
        }
    }
}
