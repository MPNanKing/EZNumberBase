package com.cn.leekzhang.numbase.core.num;

import java.util.ArrayList;

import com.cn.leekzhang.numbase.util.Checker;
import com.cn.leekzhang.numbase.util.Transformor;

/**
 * 原始数字类
 * 包含数字的信息:数值和进制值
 * @author Leek Zhang
 *
 */
public class RawNumber {
	/**
	 * 数值的具体数字,从左往右拼接成数字 :
	 * 如list存储顺序为[1,2,3],下标0,1,2
	 * 则该值在10进制下为123,
	 * 在4进制下转为10进制为27。
	 * 具体数字脱离进制值没有任何含义。
	 * 又如list存储顺序为[11,12,13],下标0,1,2;进制必须大于等于14，
	 * 则该值在14进制下转换成10进制为11*14^+12*14+13,
	 * 在16进制下转为14进制为***。
	 */
	private ArrayList<Integer> numValue;
	
	/**
	 * 数值的进制
	 */
	private Integer numBaseType;
		
	/**
	 * RawNumber构造方法
	 * @param numBaseType 数字的进制值
	 * @param numValue 具体数字
	 */
	public RawNumber(Integer numBaseType,ArrayList<Integer> numValue){
		setValueAndType(numValue, numBaseType);
	}
	
	/**
	 * RawNumber构造方法
	 * @param numBaseType 数字的进制值
	 * @param numValue 具体数字
	 */
	public RawNumber(Integer numBaseType,Integer... arr){
		setValueAndType(Transformor.arrToList(arr), numBaseType);
	}
	
	public ArrayList<Integer> getNumValue() {
		return numValue;
	}
	
	public Integer getNumBaseType() {
		return numBaseType;
	}
	
	/**
	 * 检查属性值且设置属性值
	 * @param numValue 原数值
	 * @param numBaseType 进制值
	 */
	private void setValueAndType(ArrayList<Integer> numValue,Integer numBaseType){
		Checker.getChecker().checkRawNumber(numValue, numBaseType);
		this.numValue = numValue;
		this.numBaseType = numBaseType;
	}
	
	public void setNumValue(ArrayList<Integer> numValue){
		setValueAndType(numValue,this.numBaseType);
	}
	
	public void setNumBaseType(Integer numBaseType){
		if(numBaseType>1 && numBaseType>=this.numBaseType){
			this.numBaseType = numBaseType;
		}else{
			setValueAndType(this.numValue, numBaseType);
		}
	}
}
