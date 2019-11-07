package com.luo.item;

import com.luo.item.ColdDrink;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:58 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class Pepsi extends ColdDrink {

	@Override
	public float price() {
		return 35.0f;
	}

	@Override
	public String name() {
		return "Pepsi";
	}
}