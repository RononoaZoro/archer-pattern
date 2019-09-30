package com.luo.composite.menuiterator.custom;

import java.util.Iterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 12:16
 **/
public class MenuItemNew extends MenuComponentNew {

    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItemNew(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public Iterator<MenuComponentNew> createIterator() {

        return new NullIteratorNew();
    }

    @Override
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }
}
