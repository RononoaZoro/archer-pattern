package com.luo;

/**
 * @Description: <br>
 * @Date: 2019/11/7 15:30 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class Memento {
	private String state;

	public Memento(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}
