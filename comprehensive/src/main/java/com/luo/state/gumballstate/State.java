package com.luo.state.gumballstate;

public interface State {

	//插入硬币
	public void insertQuarter();
	//弹出硬币
	public void ejectQuarter();
	//转动曲柄
	public void turnCrank();
	//分配
	public void dispense();
	//重新填充
	public void refill();
}
