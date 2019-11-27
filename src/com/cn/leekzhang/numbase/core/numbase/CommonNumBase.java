package com.cn.leekzhang.numbase.core.numbase;

import com.cn.leekzhang.numbase.core.num.RawNumber;
import com.cn.leekzhang.numbase.exception.IllegalNumBaseTypeException;
/**
 * 普通进制类
 * @author Leek Zhang
 *
 */
public class CommonNumBase extends AbstractNumBase{

	/**
	 * CommonNumBase构造方法
	 * @param rawNumber 原始数字
	 * @param outNumBaseType 需要转换成的进制
	 * @param space toString方法是否含有空格
	 */
	public CommonNumBase(RawNumber rawNumber,Integer outNumBaseType,boolean space){
		setInfo(rawNumber, outNumBaseType, space);
	}
	/**
	 * CommonNumBase构造方法
	 * toString方法默认含有空格
	 * @param rawNumber 原始数字
	 * @param outNumBaseType 需要转换成的进制
	 */
	public CommonNumBase(RawNumber rawNumber,Integer outNumBaseType){
		setInfo(rawNumber, outNumBaseType, true);
	}

	private void setInfo(RawNumber rawNumber,Integer outNumBaseType,boolean space){
		if(outNumBaseType<1)throw new IllegalNumBaseTypeException();
		this.setRawNumber(rawNumber);
		this.setOutNumBaseType(outNumBaseType);
		this.setSpace(space);
	}
	
	/**
	 * 显示信息
	 */
	public void showInfo(){
		System.out.println("原进制:"+this.getRawNumber().getNumBaseType());
		System.out.println("\t原始数字:"+this.getRawNumber().getNumValue());
		System.out.println("现进制:"+this.getOutNumBaseType());
		System.out.println("\t变换数字:"+toNumBaseism());
	}
	

	
	

}
