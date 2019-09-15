package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public class Cheese extends ToppingDecorator {
	
 
	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}
 
	public String getDescription() {
		return pizza.getDescription() + ", Cheese";
	}
 
	public double cost() {
		return pizza.cost(); // cheese is free
	}
}
