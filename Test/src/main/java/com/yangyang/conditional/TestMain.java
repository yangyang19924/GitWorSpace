package com.yangyang.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yangyang on 2018/8/7.
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name")+"系统下的命令："+listService.showListCmd());
    }
}
