package com.yangyang.aop.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yangyang on 2018/8/7.
 */
@Configuration
@ComponentScan("com.yangyang.aop.example")
@EnableAspectJAutoProxy
public class AopConfig {

}
