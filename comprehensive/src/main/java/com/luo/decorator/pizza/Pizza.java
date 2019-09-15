package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:38
 **/
public abstract class Pizza {
    String description = "Basic Pizza";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
