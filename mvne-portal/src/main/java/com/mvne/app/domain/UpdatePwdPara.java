package com.mvne.app.domain;

import org.springframework.stereotype.Component;

@Component
public class UpdatePwdPara {

	private String billId;
	private String serverPwdOld;
	private String serverPwdNew;
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getServerPwdOld() {
		return serverPwdOld;
	}
	public void setServerPwdOld(String serverPwdOld) {
		this.serverPwdOld = serverPwdOld;
	}
	public String getServerPwdNew() {
		return serverPwdNew;
	}
	public void setServerPwdNew(String serverPwdNew) {
		this.serverPwdNew = serverPwdNew;
	}
	
}
