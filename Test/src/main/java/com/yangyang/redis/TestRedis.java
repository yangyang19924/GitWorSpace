package com.yangyang.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by yangyang on 2018/7/27.
 */
public class TestRedis {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("key2","value2");

        //通过key获取值
        String value1 = (String) redisTemplate.opsForValue().get("key1");
        System.out.println("value1: "+value1);

        //通过key删除值
        redisTemplate.delete("key1");

        //求长度
        Long length = redisTemplate.opsForValue().size("key2");
        System.out.println("length: "+length);

        //设置新值并返回旧值
        String oldValue2 = (String)redisTemplate.opsForValue().getAndSet("key2","new_value2");

        String value2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("new value2: "+value2);

        //求子串
        String rangeValue2 = redisTemplate.opsForValue().get("key2",0,4);
        System.out.println("rangeValue2: "+rangeValue2);

        //追加字符串到末尾，返回新串长度
        int newLen = redisTemplate.opsForValue().append("key2","_append");
        System.out.println("newLen: "+newLen);

        String appendValue2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("rangeValue2: " + appendValue2);  //输出new_value2 ??????
    }

}
