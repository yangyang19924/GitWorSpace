package com.yangyang.reflect;


import java.lang.reflect.Method;

/**
 * Created by yangyang on 2018/7/27.
 */
public class Test {

    public static void main(String[] args) {
        ReflectServiceImpl object = getInstance();
//        object.sayHello();
       // Object method = reflectMethod();


    }

    public static ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;


        try {
            //通过 forName 加载到类的加载器。然后通过 getConstructor 方法，它的参数可 以是多
            //个，这里定义为 String.class，意为有且只有一个参数类型为 String 的构建方法。通过这个
            //方法可以对重名方法进行排除，此时再用 newInstance 方法生成对象 ， 只是 newInstance 方
            //法也多了一个参数“张三 ”而已。实际就等于 object = new ReflectServicelmpl（”张三”）， 只
            //是这里用反射机制来生成这个对象而已。
            object = (ReflectServiceImpl)Class.forName("com.yangyang.reflect.ReflectServiceImpl").getConstructor(String.class).newInstance("zhangsan");
            Method method = object.getClass().getMethod("sayHello",String.class);
            method.invoke(object,"yangyang");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public static Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();

        try{
            Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
            returnObj = method.invoke(target,"张三");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return returnObj;
    }
}
