package com.cn.leekzhang.numbase.core.numbase;

import java.util.ArrayList;

import com.cn.leekzhang.numbase.core.num.ExceedMultipleRawNumber;
import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;
import com.cn.leekzhang.numbase.util.Checker;
import com.cn.leekzhang.numbase.util.Transformor;

/**
 * 可越界的进制类
 * 每一位数可以超过其对应的进制值，
 * 如numBaseType:10 10 10,numValue可以为11 13 20
 * 原始ExcceedRawNumber越界的不进行增加处理
 * @author Leek Zhang
 *
 */
public class ExceedMultipleNumBase extends AbstractMultipleNumBase {

	@Override
	public void setOutNumBaseType(ArrayList<Integer> outNumBaseType) {
		Checker.getChecker().checkNumBaseType(outNumBaseType);
		this.outNumBaseType = outNumBaseType;
	}

	public ExceedMultipleNumBase(ExceedMultipleRawNumber multRawNumber,ArrayList<Integer> outNumBaseType){
		this.setMultRawNumber(multRawNumber);
		this.setOutNumBaseType(outNumBaseType);
	}
	
	public ExceedMultipleNumBase(MultipleRawNumber multRawNumber,Integer... arr){
		this.setMultRawNumber(multRawNumber);
		this.setOutNumBaseType(Transformor.arrToList(arr));
	}

	

	
}
