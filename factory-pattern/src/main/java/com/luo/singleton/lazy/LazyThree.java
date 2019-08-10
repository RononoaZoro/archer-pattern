package com.luo.singleton.lazy;

/**
 * 静态内部类
 *
 * @author luoxuzheng
 * @create 2019-08-10 15:52
 **/
public class LazyThree {

    //特点：在外部类被调用的时候内部类才会被加载
    //内部类一定是要在方法调用之前初始化
    //巧妙地避免了线程安全问题
    //这种形式兼顾饿汉式的内存浪费，也兼顾synchronized性能问题
    //完美地屏蔽了这两个缺点
    private static boolean initial = false;

    //默认使用LazyThree的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyThree(){
        //防止反射侵入
        synchronized (LazyThree.class){
            if (initial == false){
                initial = !initial;
            } else {
                throw new RuntimeException("单例被侵犯");
            }
        }
    }

    private static LazyThree instance = null;

    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public final static LazyThree getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static LazyThree LAZY = new LazyThree();
    }
}
