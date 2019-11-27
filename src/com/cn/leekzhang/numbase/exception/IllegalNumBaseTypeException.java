package com.cn.leekzhang.numbase.exception;
/**
 * 非法的进制值异常。
 * 进制值必须大于等于2
 * @author Leek Zhang
 *
 */
public class IllegalNumBaseTypeException extends RuntimeException {

	private static final long serialVersionUID = -7712201169480069362L;

	public IllegalNumBaseTypeException() {
	}

	public IllegalNumBaseTypeException(String s) {
		super(s);
	}
}
