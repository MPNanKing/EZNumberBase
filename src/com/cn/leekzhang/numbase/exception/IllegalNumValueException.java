package com.cn.leekzhang.numbase.exception;
/**
 * 非法的数值异常。
 * 数值上的每一位数必须大于等于0且小于当前进制值
 * @author Leek Zhang
 *
 */
public class IllegalNumValueException extends RuntimeException {

	private static final long serialVersionUID = -8686669784410306501L;

	public IllegalNumValueException() {
		super();
	}

	public IllegalNumValueException(String s) {
		super(s);
	}
}
