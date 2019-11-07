package com.luo;

/**
 * @Description: <br>
 * @Date: 2019/11/7 14:34 <br>
 * @Author: luoxz <br>
 * @Version: 1.0 <br>
 */
public class OrExpression implements Expression{

	private Expression expr1 = null;
	private Expression expr2 = null;

	public OrExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean interpret(String context) {
		return expr1.interpret(context) || expr2.interpret(context);
	}
}
