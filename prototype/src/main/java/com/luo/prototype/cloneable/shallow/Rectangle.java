package com.luo.prototype.cloneable.shallow;

/**
 * @author luoxuzheng
 * @create 2019-08-12 11:05
 **/
public class Rectangle extends Shape {
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
