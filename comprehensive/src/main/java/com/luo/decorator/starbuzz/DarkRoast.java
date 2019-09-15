package com.luo.decorator.starbuzz;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:42
 **/
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return .99;
    }
}