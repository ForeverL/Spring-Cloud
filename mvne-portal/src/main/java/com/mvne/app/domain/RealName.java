package com.mvne.app.domain;

import org.springframework.stereotype.Component;



/***********************************************************  
* @ClassName : RealName  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:06:33  
***********************************************************/ 
@Component
public class RealName {

	private String realName;
	private String idCard;
	private String imgURLs;
	private String confirmId;

	public String getConfirmId() {
		return confirmId;
	}

	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getImgURLs() {
		return imgURLs;
	}

	public void setImgURLs(String imgURLs) {
		this.imgURLs = imgURLs;
	}

}
