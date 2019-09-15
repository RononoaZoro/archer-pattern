package com.luo.observer.simple;

/**
 * @author luoxuzheng
 * @create 2019-09-15 19:39
 **/
public class Example {

    public static void main(String[] args) {
        Subject subject = new SimpleSubject();
        Observer observer = new SimpleObserver(subject);
        ((SimpleSubject) subject).setValue(1);
    }
}
