package com.cn.leekzhang.numbase.util;

import java.util.ArrayList;
/**
 * 转换工具类
 * @author Leek_Zhang
 *
 */
public class Transformor {
	/**
	 * 将Integer[]转换成ArrayList<Integer>格式
	 * @param arg 需要转换的数组
	 * @return 转换成功的ArrayList
	 */
	public static ArrayList<Integer> arrToList(Integer... arr){
		ArrayList<Integer> arrlist = new ArrayList<>();
		for (Integer i : arr) {
			arrlist.add(i);
		}
		return arrlist;
	}
	
}
