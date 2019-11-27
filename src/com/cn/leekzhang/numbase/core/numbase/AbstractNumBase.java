package com.cn.leekzhang.numbase.core.numbase;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import com.cn.leekzhang.numbase.core.num.RawNumber;

/**
 * 抽象进制类
 * @author Leek Zhang
 *
 */
public abstract class AbstractNumBase {

	/**
	 * 要输出的的进制种类
	 * 默认为10
	 */
	private Integer outNumBaseType = 10;
	
	/**
	 * 打印有无空格
	 */
	private Boolean space = true;

	/**
	 * 原始数字
	 */
	private RawNumber rawNumber;
	
	public RawNumber getRawNumber() {
		return rawNumber;
	}

	public void setRawNumber(RawNumber rawNumber) {
		this.rawNumber = rawNumber;
	}

	public Integer getOutNumBaseType() {
		return outNumBaseType;
	}

	public void setOutNumBaseType(Integer outNumBaseType) {
		this.outNumBaseType = outNumBaseType;
	}

	public Boolean getSpace() {
		return space;
	}

	public void setSpace(Boolean space) {
		this.space = space;
	}

	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		ArrayList<Integer> nv = this.rawNumber.getNumValue();
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

	/**
	 * 将具体数值转换成所需进制的值
	 * numValue的值转换为所需进制下的值
	 * 如numValueNumBase=10,numValue=[1,2,3],numBaseType=4
	 * 123(四进制) ---> 27(十进制)
	 * @return
	 */
	public ArrayList<Integer> toNumBaseism() {	
			BigInteger num = toDec();
			return fun(num,new BigInteger(this.outNumBaseType.toString()));	
	}
	
	/**
	 * 任意进制转为10进制
	 * @return
	 */
	public BigInteger toDec(){
		//计算结果
		BigInteger result = BigInteger.ZERO;
		ArrayList<Integer> nv = this.rawNumber.getNumValue();
		//RawNumber的进制值
		BigInteger nbt = new BigInteger(this.rawNumber.getNumBaseType().toString());
		Integer size = nv.size();
			for (int i = size - 1; i >= 0; i--) {
				// 123 --> 1*n^s-1 + 2*n^s-2 + 3*n^s-3
				//所在位数-1
				BigInteger seatNum = new BigInteger(nv.get(size - i - 1).toString());
				//当前位数字的进制权重值
				BigInteger base = nbt.pow(i);
				result = result.add(seatNum.multiply(base));
			}
			return result;
	}

	/**
	 * 10进制转为任意进制
	 * @param num numValue
	 * @param nb numBaseType
	 * @return
	 */
	public ArrayList<Integer> fun(BigInteger num,BigInteger nb){
		BigInteger org = num;
		ArrayList<Integer> list = new ArrayList<>();
		if(org.compareTo(BigInteger.ZERO)==1){
			while(true){
				BigInteger yu = org.mod(nb);
				org = org.divide(nb);
				list.add(Integer.valueOf(yu.toString()));
				if(org.compareTo(BigInteger.ZERO)==0)break;
			}
		}else{
			throw new RuntimeException("Unexpected,something wrong");
		}
		Collections.reverse(list);
		return list;
		
	}
}
