package com.luo.item;

import com.luo.item.Burger;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:57 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class ChickenBurger extends Burger {

	@Override
	public float price() {
		return 50.5f;
	}

	@Override
	public String name() {
		return "Chicken Burger";
	}
}