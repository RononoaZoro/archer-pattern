package com.luo.decorator.starbuzzWithSizes;


/**
 * @author luoxuzheng
 * @create 2019-09-15 20:40
 **/
public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return beverage.cost() + .10;
	}
}
