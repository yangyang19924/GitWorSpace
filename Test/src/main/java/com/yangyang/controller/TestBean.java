package com.yangyang.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yangyang on 2018/8/3.
 */
@Configuration
public class TestBean {

    @Bean(initMethod = "init")
    //不加init-method时直接调用构造方法，同xml中不加init-method
    //加init-mehtod时先调用构造方法再调用set方法(初始化时set)，然后再调用init，同xml中加init-method
    public Test1 getTest(){
        Test1 test = new Test1();
        test.setI(1);
        return test;
    }

}
