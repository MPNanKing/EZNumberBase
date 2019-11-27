package com.cn.leekzhang.numbase.core.num;

import java.util.ArrayList;

import com.cn.leekzhang.numbase.util.Checker;
import com.cn.leekzhang.numbase.util.Transformor;
/**
 * 多重进制原始数字类
 * 包含数字的信息:数值和每一位的进制值
 * @author Leek Zhang
 *
 */
public class MultipleRawNumber {
	
	protected ArrayList<Integer> numValue;
	
	protected ArrayList<Integer> numBaseType;
	
	public MultipleRawNumber(){};
	/**
	 * RawNumber构造方法
	 * @param numBaseType 数字的进制值
	 * @param numValue 具体数字
	 */
	public MultipleRawNumber(ArrayList<Integer> numBaseType,ArrayList<Integer> numValue){
		setValueAndType(numValue, numBaseType);
	}
	
	/**
	 * RawNumber构造方法
	 * @param numBaseType 数字的进制值
	 * @param numValue 具体数字
	 */
	public MultipleRawNumber(ArrayList<Integer> numBaseType,Integer... arr){
		setValueAndType(Transformor.arrToList(arr), numBaseType);
	}
	
	public ArrayList<Integer> getNumValue() {
		return numValue;
	}
	
	public ArrayList<Integer> getNumBaseType() {
		return numBaseType;
	}
	
	/**
	 * 检查属性值且设置属性值
	 * @param numValue 原数值
	 * @param numBaseType 进制值
	 */
	private void setValueAndType(ArrayList<Integer> numValue,ArrayList<Integer> numBaseType){
		Checker.getChecker().checkMultipleRawNumber(numValue, numBaseType);
		this.numValue = numValue;
		this.numBaseType = numBaseType;
	}
	
	public void setNumValue(ArrayList<Integer> numValue){
		setValueAndType(numValue,this.numBaseType);
	}
	
	public void setNumBaseType(ArrayList<Integer> numBaseType){
		setValueAndType(this.numValue, numBaseType);
	}
	

}
