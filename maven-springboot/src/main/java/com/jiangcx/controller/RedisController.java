package com.jiangcx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String lock = "lock";

    @RequestMapping("/set")
    public String setRedis(){
        stringRedisTemplate.opsForValue().set("look","I must can look a good Job");
        //设置key的失效时间 为 30 秒
        redisTemplate.expire("look",30,TimeUnit.SECONDS);
        return "success";
    }

    @RequestMapping("/get")
    public String getRedisVal(){
        /**
         * 用redis实现分布式锁
         */
        String clientId = UUID.randomUUID().toString();
        try {
            Boolean res = stringRedisTemplate.opsForValue().
                    setIfAbsent(lock,clientId,10,TimeUnit.SECONDS);
            /*Boolean res = stringRedisTemplate.opsForValue().setIfAbsent(lock,"lockValue");
            stringRedisTemplate.expire(lock,10,TimeUnit.SECONDS);*/
            if(!res){
                return "nothing";
            }
            int stock = Integer.parseInt(String.valueOf(redisTemplate.opsForValue().get("stock")));
            if (stock > 0) {
                stock = stock - 1;
                redisTemplate.opsForValue().set("stock", stock + "");
                System.out.println("取票成功，剩余票数为：" + stock);
            } else {
                System.out.println("取票失败，余票不足！");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }finally {
            if(clientId.equals(stringRedisTemplate.opsForValue().get(lock))){
                stringRedisTemplate.delete(lock);
            }
        }

        return "over";
    }

}
