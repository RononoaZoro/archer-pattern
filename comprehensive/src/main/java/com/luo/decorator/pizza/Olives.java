package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public class Olives extends ToppingDecorator {
	
 
	public Olives(Pizza pizza) {
		this.pizza = pizza;
	}
 
	public String getDescription() {
		return pizza.getDescription() + ", Olives";
	}
 
	public double cost() {
		return pizza.cost() + .30; 
	}
}
