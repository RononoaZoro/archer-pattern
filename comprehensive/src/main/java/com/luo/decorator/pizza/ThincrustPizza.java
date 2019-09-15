package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public class ThincrustPizza extends Pizza {
  
	public ThincrustPizza() {
		description = "Thin crust pizza, with tomato sauce";
	}
  
	public double cost() {
		return 7.99;
	}
}

