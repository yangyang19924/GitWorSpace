package com.yangyang.threadPool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 线程池任务
 * Created by yangyang on 2018/8/7.
 */
@Service
public class TaskService {

    @Async  //加此注解就是异步执行的任务
    public void executeAsyncTask(int i) {
        System.out.println("执行异步任务1："+i);
    }

    @Async
    public void executeAsyncTask1(int i) {
        System.out.println("执行异步任务2:"+i);
    }
}
