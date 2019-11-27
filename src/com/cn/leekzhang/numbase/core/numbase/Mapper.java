package com.cn.leekzhang.numbase.core.numbase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

public interface Mapper {
	public static String fileName = "numberMapper";
	public static final String FILE_PATH = "resource/numberMapper.properties";
	
	/**
	 * 依据path找到properties映射文件
	 * 逐个进行映射
	 * @param iList 需要进行映射的集合
	 * @param path 映射文件路径
     * @return 返回为ArrayList<String>类型
     */
	default public ArrayList<String> toMapping(ArrayList<Integer> iList,String path){
		Properties prop = new Properties();
		BufferedReader reader = null;
		try {
			if(null==path||path.length()<1){
				reader = new BufferedReader(new FileReader(Mapper.FILE_PATH));
			}else{
				reader = new BufferedReader(new FileReader(path));
			}
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@SuppressWarnings("unchecked")
		Hashtable<String, String> table = (Hashtable<String, String>) prop.clone();
		if(iList==null){
			iList = getImplNumValue();
		}
		ArrayList<String> sList = new ArrayList<>();
		for (Integer i : iList) {
			String s = String.valueOf(i);
			if(table.containsKey(s)){
				sList.add(table.get(s));
			}else{
				sList.add(String.valueOf(i));
			}
		}
		return sList;
	}
	
	/**
	 * 使用默认的properties映射文件
	 * 逐个进行映射
	 * @return
	 */
	default public ArrayList<String> toMapping(){
		return toMapping(null,null);
	}
	/**
	 * 获取实现类中的numValue
	 */
	 public ArrayList<Integer> getImplNumValue();
}
