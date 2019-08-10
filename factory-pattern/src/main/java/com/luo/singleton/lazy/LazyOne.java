package com.luo.singleton.lazy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoxuzheng
 * @create 2019-08-10 15:41
 **/
public class LazyOne {

    //相比饿汉式，是以时间换空间，存在线程安全问题
    //解决线程安全问题，一般是在getInstance()方法上加锁 synchronized
    // 或 ReentrantLock lock = new ReentrantLock();,但会影响性能
    private LazyOne() {
    }

    private static LazyOne instance = null;

    public static LazyOne getInstance() {
        if (instance == null) {
            instance = new LazyOne();
        }
        return instance;
    }
}
