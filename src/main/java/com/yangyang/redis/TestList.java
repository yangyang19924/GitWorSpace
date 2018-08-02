package com.yangyang.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.connection.srp.SrpConnection;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyang on 2018/7/30.
 */
public class TestList {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-redis.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        redisTemplate.delete("list");

        //插入node3
        redisTemplate.opsForList().leftPush("list","node3");
        List<String> nodeList = new ArrayList<>();
        for(int i = 2;i>=1;i--) {
            nodeList.add("node"+i);
        }

        //插入多个值
        redisTemplate.opsForList().leftPushAll("list",nodeList);

        //右侧插入
        redisTemplate.opsForList().rightPush("list","node4");

        //获取下标为 0 的节点
        String node1 = (String) redisTemplate.opsForList().index("list",0);

        System.out.println(node1); //node1

        //获取链表长度
        System.out.println(redisTemplate.opsForList().size("list")); //4

        //从左边弹出 一个节点
        String lpop = (String) redisTemplate.opsForList().leftPop("list");
        System.out.println(lpop);  //node1

        String rpop = (String) redisTemplate.opsForList().rightPop("list");
        System.out.println(rpop);  //node4

        try {
            //使用 linsert 命令在 node2 前插入一个节点
            redisTemplate.getConnectionFactory().getConnection().lInsert("list".getBytes("utf-8"),RedisListCommands.Position.BEFORE,"node2".getBytes("utf-8"),"before_node".getBytes("utf-8"));

            //使用 linsert 命令在 node2 后插入一个节点
            redisTemplate.getConnectionFactory().getConnection().lInsert("list".getBytes("utf-8"),RedisListCommands.Position.AFTER,"node2".getBytes("utf-8"),"after_node".getBytes("utf-8"));

            System.out.println(redisTemplate.opsForList().size("list"));  //4

            //判断 list 是否存在，如果存在则从左边插入 head 节点
            redisTemplate.opsForList().leftPushIfPresent("list","head");

            //判断 list 是否存在，如果存在则从右边插入 end 节点
            redisTemplate.opsForList().rightPushIfPresent("list","end");

            List valueList = redisTemplate.opsForList().range("list",0,10);
            System.out.println(valueList);   //[head, before_node, node2, after_node, node3, end]

            nodeList.clear();
            for(int i=1;i<=3;i++) {
                nodeList.add("node");
            }

            //／在链表左边插入三个值为 node 的节点
            redisTemplate.opsForList().leftPushAll("list",nodeList);

            //／从左到右删除至多三个 node 节点
            redisTemplate.opsForList().remove("list",3,"node");

            //／给链表下标为 0 的节点设置新值
            redisTemplate.opsForList().set("list",0,"new_head_value");

            System.out.println(redisTemplate.opsForList().range("list",0,redisTemplate.opsForList().size("list")));  //[new_head_value, before_node, node2, after_node, node3, end]
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
