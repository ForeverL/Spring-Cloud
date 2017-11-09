package com.mvne.app.domain;

import org.springframework.stereotype.Component;


/***********************************************************  
* @ClassName : Order  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:06:06  
***********************************************************/ 
@Component
public class Order {

	private String provCd;
	private String cityCd;
	private String phoneNum;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;

	public String getProvCd() {
		return provCd;
	}

	public void setProvCd(String provCd) {
		this.provCd = provCd;
	}

	public String getCityCd() {
		return cityCd;
	}

	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}


}
