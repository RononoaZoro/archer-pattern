package com.luo.decorator;

/**
 * 鸭鸣计数器
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:09
 **/
public class QuackCounterDecorator implements Quackable {

    private Quackable quackable;
    private static Integer numberOfQuacks = 0;

    public QuackCounterDecorator(Quackable quackable) {
        this.quackable = quackable;
    }

    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static Integer getNumberOfQuacks() {
        return numberOfQuacks;
    }
}
