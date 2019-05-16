package com.jiangcx.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jiangcx on 2019/3/15
 */
@Configuration
@EnableCaching
public class RedisConfig {

    public RedisConfig() {
        System.out.println("初始化RedisConfig容器。。。。。。。。。。。。。。。。。");
    }

    /**
     * 配置连接池对象
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool") //用配置文件的参数自动注入
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
       /* //设置最大空闲shu
        jedisPoolConfig.setMaxIdle(10);
        //设置最小空闲数
        jedisPoolConfig.setMinIdle(0);
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(20);*/
        return jedisPoolConfig;
    }

    /**
     * 配置redis的连接信息
     * @param config
     * @return
     */
    @Bean
    //@ConfigurationProperties(prefix = "spring.redis") //用配置文件的参数自动注入
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig config){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("192.168.1.102");
        redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setPassword("123456");

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        jpcf.poolConfig(config);
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();

        return new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);
        //设置redis的序列化器
        setSerializer(redisTemplate);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @SuppressWarnings("all") //抑制警告
    private void setSerializer(RedisTemplate redisTemplate) {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    }
}
