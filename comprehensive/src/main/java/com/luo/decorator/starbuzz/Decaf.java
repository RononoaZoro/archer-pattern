package com.luo.decorator.starbuzz;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:42
 **/
public class Decaf extends Beverage{
    public Decaf() {
        description = "Decaf Coffee";
    }

    public double cost() {
        return 1.05;
    }
}
