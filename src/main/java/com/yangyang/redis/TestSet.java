package com.yangyang.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

/**
 * Created by yangyang on 2018/7/30.
 */
public class TestSet {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        Set set = null;

        //将元素加入列表
        redisTemplate.boundSetOps("set1").add("v1","v2","v3","v4","v5","v6");
        redisTemplate.boundSetOps("set2").add("v0","v2","v4","v6","v8");

        System.out.println(redisTemplate.opsForSet().size("set1"));  //6

        //求差集
        set = redisTemplate.opsForSet().difference("set1","set2"); //[v1, v3, v5]
        System.out.println(set);

        //求交集
        set = redisTemplate.opsForSet().intersect("set1","set2");  //[v6, v4, v2]
        System.out.println(set);

        //判断是否是集合中的元素
        boolean e = redisTemplate.opsForSet().isMember("set1","v1");  //true
        System.out.println(e);

        //／获取集合所有元素
        set = redisTemplate.opsForSet().members("set1");  //[v1, v6, v4, v3, v5, v2]
        System.out.println(set);

        //从集合中随机弹出一个元素
        String val = (String) redisTemplate.opsForSet().pop("set1");
        System.out.println(val);

        //随机获取一个集合的元素
        val = (String) redisTemplate.opsForSet().randomMember("set1");
        System.out.println(val);

        //／随机获取 2 个集合的元素
        List list = redisTemplate.opsForSet().randomMembers("set1",2L);

        //删除一个集合的元素，参数可以是多个
        redisTemplate.opsForSet().remove("set1","v1");

        //／求两个集合的并集
        redisTemplate.opsForSet().union("set1","set2");

        //／求两个集合的差集，并保存到集合 diff set 中
        redisTemplate.opsForSet().differenceAndStore("set1","set2","diff_set");

        //／求两个集合的交集，并保存到集合 inter set 中
        redisTemplate.opsForSet().intersectAndStore("set1","set2","inter_set");

        //／求两个集合的并集，并保存到集合 union set 中
        redisTemplate.opsForSet().unionAndStore("set1","set2","union_set");
    }
}
