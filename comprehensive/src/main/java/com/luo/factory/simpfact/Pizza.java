package com.luo.factory.simpfact;

import java.util.ArrayList;

/**
 * @author luoxuzheng
 * @create 2019-09-15 21:17
 **/
public class Pizza {
    String name;
    //面团
    String dough;
    //调味酱
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    public String getName() {
        return name;
    }

    //准备
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    //烘焙
    public void bake() {
        System.out.println("Baking " + name);
    }

    //切片
    public void cut() {
        System.out.println("Cutting " + name);
    }

    //包装
    public void box() {
        System.out.println("Boxing " + name);
    }

    public String toString() {
        // code to display pizza name and ingredients
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }
}
