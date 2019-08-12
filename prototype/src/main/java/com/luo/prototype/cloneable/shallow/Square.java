package com.luo.prototype.cloneable.shallow;

/**
 * @author luoxuzheng
 * @create 2019-08-12 11:06
 **/
public class Square extends Shape {
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
