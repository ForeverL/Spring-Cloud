package com.mvne.app.domain;

import org.springframework.stereotype.Component;


@Component
public class ChgCmCustPara {

	private String idCardNO;
	private String custName;
	private String address;
	private String email;
	public String getIdCardNO() {
		return idCardNO;
	}
	public void setIdCardNO(String idCardNO) {
		this.idCardNO = idCardNO;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
