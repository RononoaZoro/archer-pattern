package com.luo.factory.simpfact;

/**
 * @author luoxuzheng
 * @create 2019-09-15 21:17
 **/
public class ClamPizza extends Pizza {
	public ClamPizza() {
		name = "Clam Pizza";
		dough = "Thin crust";
		sauce = "White garlic sauce";
		toppings.add("Clams");
		toppings.add("Grated parmesan cheese");
	}
}
