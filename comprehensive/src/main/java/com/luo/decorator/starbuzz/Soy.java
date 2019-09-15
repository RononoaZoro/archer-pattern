package com.luo.decorator.starbuzz;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:42
 **/
public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
