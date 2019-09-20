package com.luo.strategy;

import com.luo.strategy.abst.Duck;
import com.luo.strategy.impl.fly.FlyWithWings;

/**
 * Hello world!
 *
 * 设计原则
 * 1、找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起（封装变化），把变化的流程变成类
 * 2、针对接口编程，而不是针对实现类
 * 3、多用组合，少用继承
 * 4、为了交互对象之间的松耦合设计而努力
 * 5、类应该对修改关闭，对拓展开放，但没有必要每一步都遵循此原则
 * 6、要依赖抽象，不要依赖具体类
 * 7、最少知道原则：只和你的密友谈话
 * 8、好莱坞原则：别调用我们，我们会调用你
 * 9、单一原则：一个类应该只有一个引起变化的原因
 *
 */
public class DuckTest {
    public static void main( String[] args ) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.fly();



    }
}
