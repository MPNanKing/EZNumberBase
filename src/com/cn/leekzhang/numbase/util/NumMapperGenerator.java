package com.cn.leekzhang.numbase.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
/**
 * 映射文件生成类
 * @author Leek Zhang
 *
 */
public class NumMapperGenerator {

	private final String nmfile = "resource/numberMapper.properties";
	private final String file = "numberMapper";
	
	public void fun(String s){
		ResourceBundle rs = ResourceBundle.getBundle(file);
		String a = rs.getString(s);
		System.out.println(a);
		
	}
	
	/**
	 * 简单的properties生成方法
	 */
	public void gentrator(){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(nmfile));
			int preset = 37;
			for(int i=11;i<73;i++){
				char c = (char)(i+65-11);
				String s = i+"="+c;
				System.out.println(s);
				writer.write(s);
				writer.newLine();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		NumMapperGenerator g = new NumMapperGenerator();
		g.gentrator();
	}
	
}
