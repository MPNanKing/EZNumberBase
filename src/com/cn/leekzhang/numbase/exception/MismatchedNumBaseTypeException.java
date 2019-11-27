package com.cn.leekzhang.numbase.exception;
/**
 * 不匹配的原数值和进制值异常。
 * 在多重进制类中使用，
 * 原数值长度必须等于进制值长度
 * @author Leek Zhang
 *
 */
public class MismatchedNumBaseTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8310824180800101932L;

	public MismatchedNumBaseTypeException() {
		super();
	}

	public MismatchedNumBaseTypeException(String s) {
		super(s);
	}
}
