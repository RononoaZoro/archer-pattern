package com.luo.hasA;

import com.luo.hasA.abst.Duck;
import com.luo.hasA.impl.fly.FlyWithWings;

/**
 * Hello world!
 *
 * 设计原则
 * 1、找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起（封装变化）
 * 2、针对接口编程，而不是针对实现类
 * 3、多用组合，少用继承
 *
 */
public class DuckTest {
    public static void main( String[] args ) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.fly();
    }
}
