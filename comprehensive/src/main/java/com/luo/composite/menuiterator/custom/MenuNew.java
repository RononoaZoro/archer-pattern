package com.luo.composite.menuiterator.custom;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 10:39
 **/
public class MenuNew extends MenuComponentNew {
	Iterator<MenuComponentNew> iterator = null;
	ArrayList<MenuComponentNew> menuComponents = new ArrayList<MenuComponentNew>();
	String name;
	String description;
  
	public MenuNew(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponentNew menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(MenuComponentNew menuComponent) {
		menuComponents.remove(menuComponent);
	}

	@Override
	public MenuComponentNew getChild(int i) {
		return menuComponents.get(i);
	}

	@Override
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}

	@Override
	public Iterator<MenuComponentNew> createIterator() {
		if (iterator == null) {
			iterator = new CompositeIteratorNew(menuComponents.iterator());
		}
		return iterator;
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		Iterator<MenuComponentNew> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponentNew menuComponent = iterator.next();
			menuComponent.print();
		}
	}
}
