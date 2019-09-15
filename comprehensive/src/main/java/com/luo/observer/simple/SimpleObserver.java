package com.luo.observer.simple;

/**
 * @author luoxuzheng
 * @create 2019-09-15 19:47
 **/
public class SimpleObserver implements Observer {

    //通知数据
    private Integer value;
    private Subject subject;

    public SimpleObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Integer value) {
        this.value = value;
        display();
    }

    public void display() {
        System.out.println("value:" + value);
    }
}
