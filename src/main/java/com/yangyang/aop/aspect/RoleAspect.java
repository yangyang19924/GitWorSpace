package com.yangyang.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by yangyang on 2018/7/26.
 */
//@Aspect
public class RoleAspect {   //在 Spring 中只要使用＠Aspect 注解一个类，那么 Spring IoC 容器就会认为这是一个切面了

    //@Before("execution(* com.yangyang.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void before(){
        System.out.println("before....");
    }

    //@After("execution(* com.yangyang.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void after() {
        System.out.println("after...");
    }

    //@AfterReturning("execution(* com.yangyang.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    //@AfterThrowing("execution(* com.yangyang.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    //@Around("execution(* com.yangyang.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("around before....");
        try {
            joinPoint.proceed();  //回调原有流程
        } catch (Throwable e) {
            new RuntimeException("回调原有流程产生异常");
        }
        System.out.println("around after....");
    }
}
