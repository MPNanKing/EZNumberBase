package com.cn.leekzhang.numbase.core.numbase;

import java.math.BigInteger;
import java.util.ArrayList;

import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;
import com.cn.leekzhang.numbase.util.Calculator;
import com.cn.leekzhang.numbase.util.Checker;

/**
 * 抽象的多重进制类
 * @author Leek Zhang
 *
 */
public abstract class AbstractMultipleNumBase {

	/**
	 * 输出的进制格式
	 */
	protected ArrayList<Integer> outNumBaseType;
	
	/**
	 * toString有无空格
	 */
	protected Boolean space = true;

	/**
	 * 多重进制原始数字
	 */
	protected MultipleRawNumber multRawNumber;

	protected ArrayList<Integer> getOutNumBaseType() {
		return outNumBaseType;
	}

	/**
	 * 设置转换的每一位进制
	 * 并检查其是否能兼容原有numBaseType
	 * @param outNumBaseType 需要转换到的进制类型
	 */
	public void setOutNumBaseType(ArrayList<Integer> outNumBaseType) {
		Checker.getChecker().checkOutNumBaseType(this.multRawNumber, outNumBaseType);
		this.outNumBaseType = outNumBaseType;
	}

	public Boolean getSpace() {
		return space;
	}

	public void setSpace(Boolean space) {
		this.space = space;
	}

	public MultipleRawNumber getMultRawNumber() {
		return multRawNumber;
	}

	public void setMultRawNumber(MultipleRawNumber multRawNumber) {
		this.multRawNumber = multRawNumber;
	}
	
	/**
	 * 任意多重进制转为10进制
	 * @return
	 */
	public BigInteger toDec(){
		return Calculator.numValueToDecimal(multRawNumber);
	}
	
	/**
	 * 将具体数值转换成所需进制的值
	 * @return 进制转换后的结果 
	 */
	public ArrayList<Integer> toNumBaseism() {	
		return Calculator.decToNumBase(toDec(),this.outNumBaseType);	
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		ArrayList<Integer> nv = this.multRawNumber.getNumValue();
		if (space) {
			for (int i = 0; i < nv.size(); i++) {
				value.append(nv.get(i)).append(" ");
			}
		} else {
			for (int i = 0; i < nv.size(); i++) {
				value.append(nv.get(i));
			}
		}
		return value.toString();
	}

}
