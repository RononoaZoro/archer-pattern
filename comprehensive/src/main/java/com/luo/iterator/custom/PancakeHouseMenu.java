package com.luo.iterator.custom;

import java.util.ArrayList;

/**
 * @author luoxuzheng
 * @create 2019-09-30 10:07
 **/
public class PancakeHouseMenu implements Menu {
	ArrayList<String> menuItems;
 
	public PancakeHouseMenu() {
		menuItems = new ArrayList<String>();
    
		addItem("K&B's Pancake Breakfast");
		addItem("Regular Pancake Breakfast");
		addItem("Blueberry Pancakes");
		addItem("Waffles");
	}

	public void addItem(String name)
	{
		menuItems.add(name);
	}
 
	public ArrayList<String> getMenuItems() {
		return menuItems;
	}
  
	public Iterator createIterator() {
		return new PancakeHouseMenuIterator(menuItems);
	}
  
	public String toString() {
		return "Pancake House MenuNew";
	}

	// other menu methods here
}
