package com.luo;

/**
 * @Description: <br>
 * @Date: 2019/11/7 15:00 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost: " +vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-Veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " +nonVegMeal.getCost());
	}
}