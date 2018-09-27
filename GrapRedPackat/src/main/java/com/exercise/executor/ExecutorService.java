package com.exercise.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/8/12.
 */
@Service
public class ExecutorService {

    @Async
    public void executeAsyncTask(int i) {
        System.out.println("执行异步任务1："+i);
    }

    @Async
    public void executeAsyncTask1(int i) {
        System.out.println("执行异步任务2:"+i);
    }
}
