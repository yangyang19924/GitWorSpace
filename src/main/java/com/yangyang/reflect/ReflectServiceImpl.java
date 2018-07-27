package com.yangyang.reflect;

/**
 * Created by yangyang on 2018/7/27.
 */
public class ReflectServiceImpl {

    private String name;

    public ReflectServiceImpl(){}
    public ReflectServiceImpl(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello! "+ name);
    }

    public void sayHello(String name1) {
        System.out.println("hello! "+ name1);
    }
}
