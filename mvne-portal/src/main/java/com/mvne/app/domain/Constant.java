/**  
* All rights Reserved, Designed By zengxf  
* @Project mvne-customer 
* @File Constant.java
* @Package com.cmsz.mvne.customer.common
* @date 2017年10月15日 
*/
    
package com.mvne.app.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
* @ClassName: Constant
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zengxf
* @date 2017年10月15日
* @version V1.0  
*/

@Component
public class Constant {
	
	public static final String EXPIRE_DATE = "2099-12-31";
	
	public static final String SUCCESS_CODE = "0000";
	public static final String SUCCESS_MESSAGE = "成功";
	
	public static final String ERROR_OF_MUSTPARA_NULL_CODE = "3001";
	public static final String ERROR_OF_MUSTPARA_NULL_MESSAGE = "输入的必选参数为空";

	public static final String ERROR_OF_MUSTPARA_FORMAT_CODE = "3002";
	public static final String ERROR_OF_MUSTPARA_FORMAT_MESSAGE = "输入的必选参数格式有误";
	
	public static final String ERROR_OF_IDENTIFIED_CODE = "3003";
	public static final String ERROR_OF_IDENTIFIED_MESSAGE = "身份证信息有误";

	public static final String ERROR_OF_SERVERPWD_CODE = "3004";
	public static final String ERROR_OF_SERVERPWD_MESSAGE = "用户服务密码错误";

	public static final String ERROR_OF_NONE_USER_CODE = "3005";
	public static final String ERROR_OF_NONE_USER_MESSAGE = "用户信息不存在";
	
	public static final String ERROR_OF_NONE_CUSTOMER_CODE = "3006";
	public static final String ERROR_OF_NONE_CUSTOMER_MESSAGE = "客户信息不存在";
	
	
	public static final String ERROR_OF_NONE_ORIGINALCUSTOMER_CODE = "3013";
	public static final String ERROR_OF_NONE_ORIGINALCUSTOMER_MESSAGE = "用户初始客户信息不存在";
	
	public static final String ERROR_OF_DATASOURCE_DEAL_CODE = "3101";
	public static final String ERROR_OF_DATASOURCE_DEAL_MESSAGE = "数据库处理错误";
	
	public static final String ERROR_OF_SAVE_TO_PICTURESERVER_CODE = "3102";
	public static final String ERROR_OF_SAVE_TO_PICTURESERVER_MESSAGE = "图片服务器报错失败";

	public static final String ERROR_OF_GET_TO_PICTURESERVER_CODE = "3103";
	public static final String ERROR_OF_GET_TO_PICTURESERVER_MESSAGE = "图片服务器获取失败";
	
	public static final String ERROR_OF_OTHERS_CODE = "3999";
	public static final String ERROR_OF_OTHERS_MESSAGE = "其他错误";
	
	public static Date getExpireDate() throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(Constant.EXPIRE_DATE);
	}

}
