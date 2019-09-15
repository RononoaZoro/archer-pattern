package com.luo.decorator.starbuzz;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:42
 **/
public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
