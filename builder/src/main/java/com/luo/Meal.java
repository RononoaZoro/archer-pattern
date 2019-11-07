package com.luo;

import com.luo.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:58 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class Meal {
	private List<Item> items = new ArrayList<Item>();

	public void addItem(Item item){
		items.add(item);
	}

	public float getCost(){
		float cost = 0.0f;
		for (Item item : items) {
			cost += item.price();
		}
		return cost;
	}

	public void showItems(){
		for (Item item : items) {
			System.out.print("Item : "+item.name());
			System.out.print(", Packing : "+item.packing().pack());
			System.out.println(", Price : "+item.price());
		}
	}
}