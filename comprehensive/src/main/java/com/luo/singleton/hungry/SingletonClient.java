package com.luo.singleton.hungry;

/**
 * 饿汉式
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:50
 **/
public class SingletonClient {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getDescription());
	}
}
