package com.yangyang.reflect.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yangyang on 2018/7/27.
 */
public class JdkProxyExample implements InvocationHandler{

    private Object target = null;


    //建立代理对象和真实对象的代理关系，并返回代理对象
    public Object bind(Object target) {
        this.target = target;

        //第1个是类加载器，我们采用了 target 本身 的类加载器 。
        //第2个是把生成的动态代理对象下挂在哪些接口下,这个写法就是放在 target 实现
        //的接口下。HelloWorldlmpl对象的接口显然就是 HelloWorld，代理对象可 以这样声
        //明;HelloWorld proxy = xxxx。
        //第3个是定义实现方法逻辑的代理类， this 表示当前对象，它必须实现InvocationHandler 接口的 invoke 方法 ，它就是代理逻辑方法的现实方法。
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果返回
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target,args); //相当于调用 sayHelloWorld
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
