package com.luo;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:33 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class TerminalExpression implements Expression{

	private String data;

	public TerminalExpression(String data){
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		if(context.contains(data)){
			return true;
		}
		return false;
	}
}
