package com.luo.item;

import com.luo.item.Item;
import com.luo.pack.Packing;
import com.luo.pack.Wrapper;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:54 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public abstract class Burger implements Item {


	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
