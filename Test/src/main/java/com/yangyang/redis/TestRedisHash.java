package com.yangyang.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

/**
 * Created by yangyang on 2018/7/27.
 */
public class TestRedisHash {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        String key = "hash1";
        Map<String,String> map = new HashMap<>();
        map.put("f1","val1");
        map.put("f2","val2");

        redisTemplate.opsForHash().putAll(key,map);

        redisTemplate.opsForHash().put(key,"f3","val3");
        Object value = redisTemplate.opsForHash().get(key,"f3");
        System.out.println(value);  //val3

        boolean ex = redisTemplate.opsForHash().hasKey(key,"f3");
        System.out.println(ex);  //true

        Map map1 = redisTemplate.opsForHash().entries(key);

//        redisTemplate.opsForHash().increment(key,"f3",2);  //报错 ERR hash value is not an integer
//        Object value1 = redisTemplate.opsForHash().get(key,"f3");
//        System.out.println(value1);
//
//        redisTemplate.opsForHash().increment(key,"f3",4);
//        Object value2 = redisTemplate.opsForHash().get(key,"f3");
//        System.out.println(value);

        List valuelist = redisTemplate.opsForHash().values(key);
        Set keylist = redisTemplate.opsForHash().keys(key);

        List<String> fiedList = new ArrayList<>();
        fiedList.add("f1");
        fiedList.add("f2");

        List valueList2 = redisTemplate.opsForHash().multiGet(key,keylist);
        System.out.println(valueList2.size());  //3

        System.out.println(redisTemplate.opsForHash().multiGet(key,fiedList));  //[val1,val2]

        boolean success = redisTemplate.opsForHash().putIfAbsent(key,"f4","value4");

        System.out.println(success);  //true

        redisTemplate.opsForHash().delete(key,"f1","f2");

        System.out.println(redisTemplate.opsForHash().get(key,"f1"));  //null
        System.out.println(redisTemplate.opsForHash().get(key,"f4"));  //value4

        redisTemplate.delete(key);




    }

}
