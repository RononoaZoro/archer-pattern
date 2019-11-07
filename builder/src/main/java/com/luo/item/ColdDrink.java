package com.luo.item;

import com.luo.item.Item;
import com.luo.pack.Bottle;
import com.luo.pack.Packing;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:56 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
