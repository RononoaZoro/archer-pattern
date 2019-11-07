package com.luo;

import com.luo.item.ChickenBurger;
import com.luo.item.Coke;
import com.luo.item.Pepsi;
import com.luo.item.VegBurger;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:59 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class MealBuilder {
	public Meal prepareVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal (){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
