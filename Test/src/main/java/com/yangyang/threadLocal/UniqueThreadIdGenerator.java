package com.yangyang.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyang on 2018/8/21.
 */
public class UniqueThreadIdGenerator {

    private static AtomicInteger uniqueId = new AtomicInteger(0);

    private static ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue(){
           return uniqueId.getAndIncrement();
        }
    };


    public static int getCurrentThreadId(){
        return uniqueNum.get();
    }

    public static void setCurrentThreadId(int id) {
        uniqueNum.set(id);
    }

}
