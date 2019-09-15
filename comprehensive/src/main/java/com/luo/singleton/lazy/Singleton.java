package com.luo.singleton.lazy;

// NOTE: This is not thread safe!

/**
 * 懒汉式
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:50
 **/
public class Singleton {
	private static Singleton uniqueInstance;
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
	public String getDescription() {
		return "I'm a lazy Singleton!";
	}
}
