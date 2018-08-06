package com.yangyang.reflect.jdkProxy;


/**
 * Created by yangyang on 2018/7/27.
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        JdkProxyExample jdk = new JdkProxyExample();

        //绑定关系，因为挂在接口 HelloWorld 下，所以声明代理对象 HelloWo r ld proxy
        HelloWord proxy = (HelloWord)jdk.bind(new HelloWordImpl());
        proxy.sayHelloWorld();
    }
}
