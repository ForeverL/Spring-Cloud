package com.mvne.app.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 编码文件读取
 * @author Administrator
 *
 */
public class PropertiesUtils {
	
	private PropertiesUtils(){}
	
	public static Properties getPro(String filePath){
		InputStream in=null;
		Properties pros;
		try {
			File file=new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			in=new FileInputStream(filePath);
			pros=new Properties();
			pros.load(in);
			return pros;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
			}
		}
		return null;
	}
}
