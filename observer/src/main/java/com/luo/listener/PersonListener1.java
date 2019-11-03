package com.luo.listener;

/**
 * @author luoxuzheng
 * @create 2019-09-30 19:52
 **/
public class PersonListener1 implements PersonListener {
    @Override
    public void dorun(Even even) {
        //拿到事件源
        Person person = even.getPerson();
        System.out.println("人在跑之前执行的动作");
    }

    @Override
    public void doeat(Even even) {
        System.out.println("人在吃之前执行的动作");
    }
}
