package com.yangyang.aop.example;

import org.springframework.stereotype.Service;

/**
 * Created by yangyang on 2018/8/7.
 */
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add() {

    }
}
