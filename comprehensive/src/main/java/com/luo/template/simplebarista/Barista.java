package com.luo.template.simplebarista;


/**
 * 咖啡师
 * @author luoxuzheng
 * @create 2019-09-13 16:25
 **/
public class Barista {
 
	public static void main(String[] args) {
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
		System.out.println("Making tea...");
		//准备食谱
		tea.prepareRecipe();
		System.out.println("Making coffee...");
		coffee.prepareRecipe();
	}
}
