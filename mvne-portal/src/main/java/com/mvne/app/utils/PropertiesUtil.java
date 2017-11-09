package com.mvne.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	Properties properties = new Properties();

	public PropertiesUtil() {
	}

	public PropertiesUtil(String pathname) {
		properties = load(pathname);
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * @方法: load
	 * @描述: 加载一个Properties文件
	 * @参数: @param pathname Properties类型的文件
	 * @参数: @return
	 * @返回: Properties
	 * @作者: 雪悦紫颜
	 * @时间: 2016年12月22日 下午11:14:55
	 */
	public Properties load(String pathname) {
		File file = new File(pathname);
		return load(file);
	}

	/**
	 * @方法: load
	 * @描述: 加载一个Properties文件
	 * @参数: @param file Properties类型的文件
	 * @参数: @return
	 * @返回: Properties
	 * @作者: 雪悦紫颜
	 * @时间: 2017年4月24日 下午7:03:04
	 */
	public Properties load(File file) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(file);
			properties = load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * @方法: load
	 * @描述: 加载一个Properties文件
	 * @参数: @param inputStream Properties类型的文件
	 * @参数: @return
	 * @返回: Properties
	 * @作者: 雪悦紫颜
	 * @时间: 2016年12月22日 下午11:14:55
	 */
	public Properties load(InputStream inputStream) {
		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			// 释放资源
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}