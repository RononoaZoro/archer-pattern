package com.luo.decorator.starbuzzWithSizes;


/**
 * @author luoxuzheng
 * @create 2019-09-15 20:40
 **/
public abstract class Beverage {
	public enum Size { TALL, GRANDE, VENTI };
	Size size = Size.TALL;
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
 
	public abstract double cost();
}
