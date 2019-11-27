package com.cn.leekzhang.numbase.core.numbase;

import java.util.ArrayList;

import com.cn.leekzhang.numbase.core.num.MultipleRawNumber;
import com.cn.leekzhang.numbase.util.Transformor;
/**
 * 多重进制类
 * 每一位的数都有与其对应的进制值
 * 如 时间计数 14:59:59 hh:MM:ss,小时进制值为24或12,分和秒则为60
 * 则对应关系为 14--24,50--60,59--60,满值向前进一位
 * @author Leek Zhang
 *
 */
public class MultipleNumBase extends AbstractMultipleNumBase implements Mapper{

	public MultipleNumBase(MultipleRawNumber multRawNumber,ArrayList<Integer> outNumBaseType){
		this.setMultRawNumber(multRawNumber);
		this.setOutNumBaseType(outNumBaseType);
	}
	
	public MultipleNumBase(MultipleRawNumber multRawNumber,Integer... arr){
		this.setMultRawNumber(multRawNumber);
		this.setOutNumBaseType(Transformor.arrToList(arr));
	}

	@Override
	public ArrayList<Integer> getImplNumValue() {
		return this.getMultRawNumber().getNumValue();
	}
}
