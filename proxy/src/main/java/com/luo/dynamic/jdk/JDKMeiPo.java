package com.luo.dynamic.jdk;

import com.luo.steady.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luoxuzheng
 * @create 2019-08-12 14:06
 **/
public class JDKMeiPo implements InvocationHandler {

    Person target;

   public Object getInstance(Person target){
       this.target = target;

       Class<? extends Person> clazz = target.getClass();

       //以字节码重组的方式来形成一个新的代理类
       Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

       return obj;
   }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：我要给你找对象，现在已经拿到你的需求");
        System.out.println("开始物色");

        method.invoke(this.target,args);

        System.out.println("如果合适的话，就准备办事");

        return  null;
    }
}
