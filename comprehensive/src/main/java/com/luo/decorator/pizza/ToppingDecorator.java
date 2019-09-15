package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public abstract class ToppingDecorator extends Pizza {
    Pizza pizza;
    public abstract String getDescription();
}