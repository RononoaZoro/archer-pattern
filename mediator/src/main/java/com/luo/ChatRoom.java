package com.luo;

import java.util.Date;

/**
 * @Description: <br>
 * @Date: 2019/11/6 19:06 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class ChatRoom {

	public static void showMessage(User user, String message){
		System.out.println(new Date().toString()
				+ " [" + user.getName() +"] : " + message);
	}
}
