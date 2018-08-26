package com.exercise.executor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/8/12.
 */
public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        ExecutorService taskService = context.getBean(ExecutorService.class);
        for(int i=0;i<20;i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTask1(i);
        }

        context.close();
    }
}
