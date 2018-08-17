package com.yangyang.concurrent;

/**
 * Created by yangyang on 2018/8/16.
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Tread:" + Thread.currentThread() + " value: " );
    }
}
