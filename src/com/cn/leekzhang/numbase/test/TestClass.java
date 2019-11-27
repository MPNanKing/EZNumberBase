package com.cn.leekzhang.numbase.test;

import java.util.ArrayList;
import java.util.Arrays;

import com.cn.leekzhang.numbase.core.num.ExceedMultipleRawNumber;
import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;
import com.cn.leekzhang.numbase.core.numbase.ExceedMultipleNumBase;
import com.cn.leekzhang.numbase.core.numbase.MultipleNumBase;

public class TestClass {

	public static void main(String[] args) {
		Integer[] num = {11,22,0};
		Integer[] base = {12,33,10};
		Integer[] out = {12,60,60,60};
		ArrayList<Integer> numBaseType = new ArrayList<>();
		numBaseType.addAll(Arrays.asList(base));
		ArrayList<Integer> numValue =  new ArrayList<>();
		numValue.addAll(Arrays.asList(num));

		MultipleRawNumber m = new MultipleRawNumber(numBaseType, numValue);
		System.out.println(m.getNumValue());
		
		MultipleNumBase enm = new MultipleNumBase(m, out);
		System.out.println(enm.toDec());
		System.out.println(enm.toMapping(null, null));
	}

}
