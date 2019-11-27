package com.cn.leekzhang.numbase.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;

/**
 * 进制计算类
 * 处理进制转换和有关进制值的计算类
 * @author Leek Zhang
 *
 */
public class Calculator {
	/**
	 * 根据numBaseType获取numValue在十进制中的最大值
	 * @param numBaseType 进制种类
	 * @return 该进制种类的最大值的十进制表达
	 */
	public static BigInteger getMaxNumBaseValueInDecimal(ArrayList<Integer> numBaseType){
		BigInteger result = BigInteger.ZERO;
		int size = numBaseType.size();
		for(int i=0;i< size;i++){
			BigInteger base = new BigInteger(numBaseType.get(size-1).toString()).pow(size-1);
			BigInteger seatNum = new BigInteger(numBaseType.get(size-1).toString()).subtract(BigInteger.ONE);
			result = result.add(seatNum.multiply(base));
		}
		return result;
	}
	
	/**
	 * 任意多重进制转为10进制
	 * 如numBaseType=4,numValue=[1,2,3]
	 * 123(四进制) ---> 27(十进制)
	 * @return BigInteger 的十进制数值
	 */
	public static BigInteger numValueToDecimal(MultipleRawNumber multRawNumber){
		//计算结果
		BigInteger result = BigInteger.ZERO;
		//多重进制原数
		ArrayList<Integer> nv = multRawNumber.getNumValue();
		//多重进制的值
		ArrayList<Integer> nbt = multRawNumber.getNumBaseType();
		Integer size = nv.size();
			for (int i = 0;i<size;i++) {
				// 123 --> 1*n^s-1 + 2*n^s-2 + 3*n^s-3
				//当前第i位的数
				BigInteger seatNum = new BigInteger(nv.get(i).toString());
				//当前位数字的进制权重值
				BigInteger base = BigInteger.ONE;
				for(int a = i+1;a<size;a++){
					base = base.multiply(new BigInteger(nbt.get(a).toString()));
				}
				result = result.add(seatNum.multiply(base));
			}
			return result;
	}
	
	/**
	 * 10进制转为多重进制
	 * numValue的值转换为所需进制下的值
	 * 如numBaseType=10,numValue=[2,7],outNumBaseType=4
	 * 27(十进制) ---> 123(四进制)
	 * @param num numValue
	 * @param nb numBaseType
	 * @return
	 */
	public static ArrayList<Integer> decToNumBase(BigInteger num,ArrayList<Integer> nb){
		//被除数 a
		BigInteger a = num;
		ArrayList<Integer> list = new ArrayList<>();
		if(a.compareTo(BigInteger.ZERO)==1){
			int size = nb.size();
			for(int i=0;i<size;i++){
				// a = b*c + d <==> a÷b=c···d
				//被除数 a
				//除数 b
				BigInteger b = new BigInteger(nb.get(size-1).toString());
				//整数商 c
				BigInteger c = a.divide(b);
				//余数 d
				BigInteger d = a.mod(b);
				a=c;
				list.add(Integer.valueOf(d.toString()));
			}
		}else{
			throw new RuntimeException("Unexpected,something wrong");
		}
		Collections.reverse(list);
		return list;
	}
}
