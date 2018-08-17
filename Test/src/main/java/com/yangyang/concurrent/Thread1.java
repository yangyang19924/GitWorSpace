package com.yangyang.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangyang on 2018/8/16.
 */
public class Thread1 implements Runnable{

    public static ConcurrentHashMap<String,Object> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public void run() {
        concurrentHashMap.put("value1",1);
        concurrentHashMap.put("value2",2);
    }
}
