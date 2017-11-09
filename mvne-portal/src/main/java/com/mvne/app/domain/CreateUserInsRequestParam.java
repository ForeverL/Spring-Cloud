
/**  
* All rights Reserved, Designed By zengxf  
* @Project mvne-customer 
* @File CreateUserInsParam.java
* @Package com.cmsz.mvne.customer.pojo
* @date 2017年10月23日 
*/
    
package com.mvne.app.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
* @ClassName: CreateUserInsParam
* @Description: 创建三户信息接口参数
* @author zengxf
* @date 2017年10月23日
* @version V1.0  
*/

@Component
public class CreateUserInsRequestParam {
	
	private Integer custId;
	private String billId;
	private BigDecimal balance;
	private String userId;
	private String imsi;
	private String iccid;
	private String basicOrgId;
	private String mvnoId;
	private String provCode;
	private String areaCode;
	private Date succTime;
	private String ordCode;
	private Integer operId;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getBasicOrgId() {
		return basicOrgId;
	}
	public void setBasicOrgId(String basicOrgId) {
		this.basicOrgId = basicOrgId;
	}
	public String getMvnoId() {
		return mvnoId;
	}
	public void setMvnoId(String mvnoId) {
		this.mvnoId = mvnoId;
	}
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public Date getSuccTime() {
		return succTime;
	}
	public void setSuccTime(Date succTime) {
		this.succTime = succTime;
	}
	public String getOrdCode() {
		return ordCode;
	}
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	
	
	

}
