package com.mvne.app.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;



/***********************************************************  
* @ClassName : PhoneNum  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:06:19  
***********************************************************/ 
@Component
public class PhoneNum implements Serializable{

	/**  
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	*/  
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String phoneNum; // 号码
	private String phoneNumStatus; // 号码锁定状态
	private String cardType; // 号码类型
	private String pkgType; // 套餐类型
	private String provCD; // 省
	private String cityCD; // 市
	private String numRegex; // 正则
	private String numMoney; // 资费
	
	private String MVNO_ID;
	private String MNO_ID;
	

	public PhoneNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumMoney() {
		return numMoney;
	}

	public void setNumMoney(String numMoney) {
		this.numMoney = numMoney;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneNumStatus() {
		return phoneNumStatus;
	}

	public void setPhoneNumStatus(String phoneNumStatus) {
		this.phoneNumStatus = phoneNumStatus;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPkgType() {
		return pkgType;
	}

	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
	}

	public String getProvCD() {
		return provCD;
	}

	public void setProvCD(String provCD) {
		this.provCD = provCD;
	}

	public String getCityCD() {
		return cityCD;
	}

	public void setCityCD(String cityCD) {
		this.cityCD = cityCD;
	}

	public String getNumRegex() {
		return numRegex;
	}

	public void setNumRegex(String numRegex) {
		this.numRegex = numRegex;
	}

	public String getMVNO_ID() {
		return MVNO_ID;
	}

	public void setMVNO_ID(String mVNO_ID) {
		MVNO_ID = mVNO_ID;
	}

	public String getMNO_ID() {
		return MNO_ID;
	}

	public void setMNO_ID(String mNO_ID) {
		MNO_ID = mNO_ID;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : toString</p>  
	* <p>Description: </p>  
	* :@return  
	* :@see java.lang.Object#toString()  
	************************************************************/ 
	@Override
	public String toString() {
		return "PhoneNum [id=" + id + ", phoneNum=" + phoneNum + ", phoneNumStatus=" + phoneNumStatus + ", cardType="
				+ cardType + ", pkgType=" + pkgType + ", provCD=" + provCD + ", cityCD=" + cityCD + ", numRegex="
				+ numRegex + ", numMoney=" + numMoney + ", MVNO_ID=" + MVNO_ID + ", MNO_ID=" + MNO_ID + "]";
	}

}
