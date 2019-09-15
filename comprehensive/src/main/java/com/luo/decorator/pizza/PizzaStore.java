package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public class PizzaStore {
 
	public static void main(String args[]) {
		Pizza pizza = new ThincrustPizza();
		Pizza cheesePizza = new Cheese(pizza);
		Pizza greekPizza = new Olives(cheesePizza);

		System.out.println(greekPizza.getDescription() 
				+ " $" + greekPizza.cost());

	}
}
