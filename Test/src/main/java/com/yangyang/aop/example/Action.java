package com.yangyang.aop.example;

import java.lang.annotation.*;

/**
 * 编写拦截规则的注解
 * Created by yangyang on 2018/8/7.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
