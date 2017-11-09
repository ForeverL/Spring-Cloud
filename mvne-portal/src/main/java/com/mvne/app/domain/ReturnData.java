
/**  
* All rights Reserved, Designed By zengxf  
* @Project mvne_product 
* @File ResultData.java
* @Package com.cmsz.mvne.product.common
* @date 2017年10月19日 
*/
    
package com.mvne.app.domain;

import java.util.Map;

import org.springframework.stereotype.Component;


/**
* @ClassName: ResultData
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zengxf
* @date 2017年10月19日
* @version V1.0  
 * @param <T>
*/
@Component
public class ReturnData {
	
	// 返回码
	private String code = "";

	// 返回信息（正确返回描述信息，错误返回错误信息）
	private String message = "";
	
	// 返回对象
	private Object data;
	
	private Map<String, Object> returnMap;
	
	public ReturnData() {
		super();
	}
	
	public ReturnData(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ReturnData(String code, String message, Object data,Map<String, Object> returnMap) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.returnMap = returnMap;
	}
	
	public ReturnData(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getReturnObject() {
		return data;
	}

	public void setReturnObject(Object data) {
		this.data = data;
	}

	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

}
