package com.luo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: <br>
 * @Date: 2019/11/7 15:31 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state){
		mementoList.add(state);
	}

	public Memento get(int index){
		return mementoList.get(index);
	}
}
