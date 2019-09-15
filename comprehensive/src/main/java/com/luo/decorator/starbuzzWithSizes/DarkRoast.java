package com.luo.decorator.starbuzzWithSizes;


/**
 * @author luoxuzheng
 * @create 2019-09-15 20:40
 **/
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

