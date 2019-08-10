package com.luo.singleton.hungry;

/**
 * @author luoxuzheng
 * @create 2019-08-10 15:34
 **/
public class HungryOne {
    //饿汉式单例
    // 它是在类加载的时候就立即初始化，并且创建单例对象
    //优点：没有加任何的锁、执行效率比较高，
    //在用户体验上来说，比懒汉式更好
    //缺点：类加载的时候就初始化，不管你用还是不用，我都占着空间
    //浪费了内存，有可能占着茅坑不拉屎
    //绝对线程安全，在线程还没出现以前就是实例化了，不可能存在访问安全问题
    private static HungryOne instance = new HungryOne();

    private HungryOne(){};

    public static HungryOne getInstance(){
        return instance;
    }
}