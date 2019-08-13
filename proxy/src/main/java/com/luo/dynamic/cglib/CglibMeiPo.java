package com.luo.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author luoxuzheng
 * @create 2019-08-12 14:54
 **/
public class CglibMeiPo implements MethodInterceptor {


    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        Object obj = enhancer.create();

        return obj;
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务的增强

        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求");
        System.out.println("开始物色");

        methodProxy.invokeSuper(o,objects);

        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
