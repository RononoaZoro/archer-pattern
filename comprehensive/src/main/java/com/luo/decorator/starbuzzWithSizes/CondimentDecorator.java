package com.luo.decorator.starbuzzWithSizes;


/**
 * @author luoxuzheng
 * @create 2019-09-15 20:40
 **/
public abstract class CondimentDecorator extends Beverage {
	public Beverage beverage;
	public abstract String getDescription();
	
	public Size getSize() {
		return beverage.getSize();
	}
}
