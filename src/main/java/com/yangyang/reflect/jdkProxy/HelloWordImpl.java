package com.yangyang.reflect.jdkProxy;

/**
 * Created by yangyang on 2018/7/27.
 */
public class HelloWordImpl implements HelloWord {
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}
