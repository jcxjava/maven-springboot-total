package com.jiangcx.testdemo;

import com.jiangcx.MavenSpringbootApplicationTests;
import com.jiangcx.entity.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiangcx on 2019/3/13
 * redis相关测试
 */
public class SpringBootTestRedis extends MavenSpringbootApplicationTests{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SpringBootTestRedis.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations valueOperations;
    private ListOperations listOperations;
    @Before
    public void init(){
        valueOperations = this.redisTemplate.opsForValue();
        listOperations = this.redisTemplate.opsForList();
    }

    /**
     * 插入字符串
     */
    @Test
    public void testSetString(){
        valueOperations.set("name","jiangchaoxin");
    }

    /**
     * 插入对象
     */
    @Test
    public void testSetObj(){
        Student student = new Student();
        student.setSno("777");
        student.setSname("jiangcx777");
        student.setSbirthday("1998-7-7");
        student.setSsex("男");
        student.setClasses("95035");
        valueOperations.set("stuObj",student);
    }

    /**
     * 获取插入字符串、对象
     */
    @Test
    public void testGetString(){
        System.out.println(valueOperations.get("name"));
        System.out.println(valueOperations.get("stuObj"));
    }
    /**
     * 插入 list 列表
     */
    @Test
    public void testSetList(){

        listOperations.leftPush("lists","one");
        listOperations.leftPush("lists","twe");
        listOperations.leftPush("lists","three");
        listOperations.leftPush("lists","four");
        listOperations.leftPush("lists","five");
    }
    /**
     * 获取 list 列表
     */
    @Test
    public void testGetList(){
       System.out.println(listOperations.range("lists", 0, -1));
    }















    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }


    /**
     * 1. 连接池自动管理，提供了一个高度封装的“RedisTemplate”类
     * 2. 针对 jedis 客户端中大量api进行了归类封装,将同一类型操作封装为operation接口
     * ValueOperations：简单K-V操作
     * SetOperations：set类型数据操作
     * ZSetOperations：zset类型数据操作
     * HashOperations：针对map类型的数据操作
     * ListOperations：针对list类型的数据操作
     * @throws Exception
     */
    @Test
    public void testObj() throws Exception {
        Student student = new Student();
        student.setSno("666");
        student.setSname("com/jiangcx");
        student.setSbirthday("1998-1-1");
        student.setSsex("男");
        student.setClasses("95033");
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        ValueOperations<String, Student> operations=redisTemplate.opsForValue();
        operations.set("com.jiangcx", student);
        // 设置缓存，有效期为100秒
        operations.set("com.jcx", student,100, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.jcx");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
