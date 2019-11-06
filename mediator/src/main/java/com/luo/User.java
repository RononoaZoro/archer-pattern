package com.luo;

/**
 * @Description: <br>
 * @Date: 2019/11/6 19:05 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class User {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name){
		this.name  = name;
	}

	public void sendMessage(String message){
		ChatRoom.showMessage(this,message);
	}
}
