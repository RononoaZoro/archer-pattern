package com.luo.decorator.pizza;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:51
 **/
public class ThickcrustPizza extends Pizza {
  
	public ThickcrustPizza() {
		description = "Thick crust pizza, with tomato sauce";
	}
  
	public double cost() {
		return 7.99;
	}
}

