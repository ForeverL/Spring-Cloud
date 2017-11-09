/**
 * 
 */
package com.mvne.app.domain;

import org.springframework.stereotype.Component;

/**
 * @author jiangxm
 * 用于返回在进行了数据库相关数据修改后的结果，目前是包含返回码和返回描述两项内容
 */
@Component
public class ReturnResultObject {
	
	private String retcode;
	private String retdesc;
	
	public ReturnResultObject() {
		super();
	}

	public ReturnResultObject(String retcode, String retdesc) {
		super();
		this.retcode = retcode;
		this.retdesc = retdesc;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getRetdesc() {
		return retdesc;
	}

	public void setRetdesc(String retdesc) {
		this.retdesc = retdesc;
	}

	@Override
	public String toString() {
		return "ReturnResultObject [retcode=" + retcode + ", retdesc=" + retdesc + "]";
	}
}
