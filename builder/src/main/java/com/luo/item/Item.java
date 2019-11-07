package com.luo.item;

import com.luo.pack.Packing;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:51 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public interface Item {
	String name();

	Packing packing();

	float price();
}
