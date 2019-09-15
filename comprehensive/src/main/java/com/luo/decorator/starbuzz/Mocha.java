package com.luo.decorator.starbuzz;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:42
 **/
public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}
