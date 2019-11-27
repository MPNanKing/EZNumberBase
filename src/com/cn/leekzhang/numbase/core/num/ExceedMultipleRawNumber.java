package com.cn.leekzhang.numbase.core.num;

import java.util.ArrayList;

import com.cn.leekzhang.numbase.util.Checker;

/**
 * 可越界的进制原始数字类
 * 包含数字的信息:数值和每一位的进制值
 * 每一位的数值可以超过进制值限制
 * 赋值不做越界检查
 * @author Leek Zhang
 *
 */
public class ExceedMultipleRawNumber extends MultipleRawNumber {

	public ExceedMultipleRawNumber(ArrayList<Integer> numBaseType, ArrayList<Integer> numValue) {
		super();
		this.setNumBaseType(numBaseType);
		this.setNumValue(numValue);
	}


	@Override
	public void setNumValue(ArrayList<Integer> numValue){
		Checker.getChecker().checkNumValue(numValue);
		this.numValue = numValue;
	}
	
	
	
	@Override
	public void setNumBaseType(ArrayList<Integer> numBaseType){
		Checker.getChecker().checkNumBaseType(numBaseType);
		this.numBaseType = numBaseType;
	}

	
	

}
