package com.luo.listener;

/**
 * 事件监听器 相当于观察者
 * @author luoxuzheng
 * @create 2019-09-30 19:50
 **/
public interface PersonListener {
    void dorun(Even even);
    void doeat(Even even);
}

