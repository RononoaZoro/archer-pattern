package com.luo.dynamic.jdk;

import com.luo.steady.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luoxuzheng
 * @create 2019-08-12 14:16
 **/
public class JDK58 implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target){
        this.target=target;

        Class<? extends Person> clazz = target.getClass();

        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                this);

        return obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("我是58：我要给你找工作，现在已经拿到你的简历");
        System.out.println("开始投递");

        method.invoke(this.target,args);

        System.out.println("安排面试");

        return null;
    }
}
