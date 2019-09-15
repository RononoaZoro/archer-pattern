package com.luo.factory.simpfact;

/**
 * @author luoxuzheng
 * @create 2019-09-15 21:17
 **/
public class CheesePizza extends Pizza {
	public CheesePizza() {
		name = "Cheese Pizza";
		dough = "Regular Crust";
		sauce = "Marinara Pizza Sauce";
		toppings.add("Fresh Mozzarella");
		toppings.add("Parmesan");
	}
}
