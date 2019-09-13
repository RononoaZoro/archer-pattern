package com.luo.hasA.abst;

import com.luo.hasA.inter.FlyBehavior;
import com.luo.hasA.inter.QuackBehavior;

/**
 * @author luoxuzheng
 * @create 2019-09-13 16:21
 **/
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void fly(){
        this.flyBehavior.fly();
    }

    public void quack(){
        this.quackBehavior.quack();
    }

    protected abstract void display();
}
