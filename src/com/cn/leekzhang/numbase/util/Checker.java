package com.cn.leekzhang.numbase.util;

import java.math.BigInteger;
import java.util.ArrayList;

import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;
import com.cn.leekzhang.numbase.exception.IllegalNumBaseTypeException;
import com.cn.leekzhang.numbase.exception.IllegalNumValueException;
import com.cn.leekzhang.numbase.exception.MismatchedNumBaseTypeException;
/**
 * 检查类
 * 检查进制值和数值是否存在冲突
 * @author Leek Zhang
 *
 */
public class Checker {

	private static Checker checker;

	public static Checker getChecker(){
		if(null == checker)checker = new Checker();
		return checker;
	}
	
	/**
	 * 单独检查numValue是否合法
	 * @param numValue
	 */
	public void checkNumValue(ArrayList<Integer> numValue){
		for (Integer i : numValue) {
			if(i<0)throw new IllegalNumValueException("Num "+i+" is illegal");
		}
	}
	
	/**
	 * 检查RawNumber的numValue和numBaseType是否冲突
	 * @param numValue
	 * @param numBaseType
	 */
	public void checkRawNumber(ArrayList<Integer> numValue,Integer numBaseType){
		if(numBaseType<1)throw new IllegalNumBaseTypeException();
		if(numBaseType>1&&numValue.size()>0){
			for (Integer i : numValue) {
				if(i>=numBaseType||i<0)throw new IllegalNumValueException();
			}
		}else{
			throw new IllegalNumValueException("ArrayList size must above 1");
		}
	}
	
	/**
	 * 检查MultipleRawNumber的numValue和numBaseType是否冲突
	 * @param numValue
	 * @param numBaseType
	 */
	public void checkMultipleRawNumber(ArrayList<Integer> numValue,ArrayList<Integer> numBaseType){
		if(numValue.size()==0)throw new IllegalNumValueException("ArrayList size must above 1");
		if(numValue.size()>numBaseType.size())throw new MismatchedNumBaseTypeException();
		for(int i=numValue.size()-1;i>0;i--){
			if(numValue.get(i)<0)throw new IllegalNumValueException();
			if(numValue.get(i)>=numBaseType.get(i))throw new IllegalNumBaseTypeException("NumValue's value at the "+i+" index is above numBaseType's value over there.");
		}
	}
	
	/**
	 * 检查outNumBaseType是否兼容
	 * outNumBaseType最大值必须大于原有numBaseType最大值
	 * @param numBaseType
	 * @param outNumBaseType
	 */
	public void checkOutNumBaseType(MultipleRawNumber multRawNum,ArrayList<Integer> outNumBaseType){
		BigInteger org = Calculator.numValueToDecimal(multRawNum);
		BigInteger out = Calculator.getMaxNumBaseValueInDecimal(outNumBaseType);
		if(org.compareTo(out)==1)throw new MismatchedNumBaseTypeException("The outNumBase's max value must above the numBaseType's max value.");
	}
	
	/**
	 * 检查numBaseType是否正常
	 * @param numBaseType
	 */
	public void checkNumBaseType(ArrayList<Integer> numBaseType){
		for (Integer i : numBaseType) {
			if(i<1)throw new IllegalNumBaseTypeException();
		}
	}
	
	/**
	 * 检查numBaseType是否正常
	 * @param numBaseType
	 */
	public void checkNumBaseType(Integer numBaseType){
		if(numBaseType<1)throw new IllegalNumBaseTypeException();
	}
}
