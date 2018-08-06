package com.yangyang.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yangyang on 2018/7/30.
 */
public class TestZset {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        redisTemplate.delete("zset1");
        redisTemplate.delete("zset2");

        //Spring 提供接口 TypedTuple 操作有序集合
        Set<ZSetOperations.TypedTuple> set1 = new HashSet<>();
        Set<ZSetOperations.TypedTuple> set2 = new HashSet<>();

        int j = 9;
        for (int i = 1; i <= 9; i++) {
            j--;

            //计算分数和值
            Double score1 = Double.valueOf(i);
            String value1 = "x" + i;
            Double score2 = Double.valueOf(j);
            String value2 = j % 2 == 1 ? "y" + j : "x" + j;

            ZSetOperations.TypedTuple typedTuple1 = new DefaultTypedTuple(value1,score1);
            ZSetOperations.TypedTuple typedTuple2 = new DefaultTypedTuple(value2,score2);
            set1.add(typedTuple1);
            set2.add(typedTuple2);
        }

        //将元素插入有序集合
        redisTemplate.opsForZSet().add("zset1",set1);
        redisTemplate.opsForZSet().add("zset2",set2);

        //统计总数
        Long size = redisTemplate.opsForZSet().zCard("zset1");
        System.out.println(size); //9

        //计分数为 score ，那么下面的方法就是求 3<=score<=6 的元素
        size = redisTemplate.opsForZSet().count("zset1",3,6);
        System.out.println(size); //4

        //从下标1开始截取 5 个元素，但是不返回分数 ， 每一个元素是String
        Set set = redisTemplate.opsForZSet().range("zset1",1,5);
        printSet(set);  //x2  x3  x4  x5  x6

        //截取集合所有元素，并且对集合按分数排序，并返回分数 ， 每一个元素是 TypedTuple
        set = redisTemplate.opsForZSet().rangeWithScores("zset1",0,-1);
        printTypedTuple(set);

        //将 zsetl 和 zset2 两个集合的交集放入集合 inter zset
        size = redisTemplate.opsForZSet().intersectAndStore("zset1","zset2","inter_zset");

        //／求排行，排名第 1 返回 0 ，第 2 返回 1
        Long rank = redisTemplate.opsForZSet().rank("zset1","x4");
        System.out.println("rank = "+rank);

        //／删除元索 ， 返回删除个数
        size = redisTemplate.opsForZSet().remove("zset1","x5","x6");
        System.out.println(size);

        //删除下标为1和2的元素
        size = redisTemplate.opsForZSet().removeRange("zset2",1,2);
        System.out.println(size);


        //／给集合中的一个元素的分数加上 11
        Double db1 = redisTemplate.opsForZSet().incrementScore("zset1","x1",11);

        //按分数删除
        redisTemplate.opsForZSet().removeRangeByScore("zset1",1,2);

        set = redisTemplate.opsForZSet().reverseRangeWithScores("zset2",1,10);
        printTypedTuple(set);


    }

    private static void printTypedTuple(Set<ZSetOperations.TypedTuple> set) {
        if(set == null || set.isEmpty()) {
            return;
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple val = (ZSetOperations.TypedTuple) iterator.next();
            System.out.println("{value = "+val.getValue()+",score = "+val.getScore()+"}  ");
        }
        System.out.println();
    }

    private static void printSet(Set set) {

        if(set == null || set.isEmpty())
            return;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object val = iterator.next();
            System.out.print(val+"  ");
        }
        System.out.println();
    }
}
