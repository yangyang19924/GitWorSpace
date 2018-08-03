package com.yangyang.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yangyang on 2018/8/3.
 */
@Configuration
public class TestBean {

    @Bean
    public Test1 getTest(){
        Test1 test = new Test1();
        return test;
    }

}
