package com.yangyang.threadPool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yangyang on 2018/8/7.
 */
public class TestTaskExecutor {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
//        TaskService taskService = context.getBean(TaskService.class);
//        for(int i=0;i<20;i++) {
//            taskService.executeAsyncTask(i);
//            taskService.executeAsyncTask1(i);
//        }
//
//        context.close();
    }
}
