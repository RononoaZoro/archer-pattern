package com.luo.decorator.starbuzz;

/**
 * 调味品装饰者抽象类
 *
 * @author luoxuzheng
 * @create 2019-09-15 20:40
 **/
public abstract class CondimentDecorator extends Beverage{

    Beverage beverage;
    public abstract String getDescription();

}
