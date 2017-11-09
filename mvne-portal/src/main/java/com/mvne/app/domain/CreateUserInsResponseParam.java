
/**  
* All rights Reserved, Designed By zengxf  
* @Project mvne-customer 
* @File CreateUserInsResponseParam.java
* @Package com.cmsz.mvne.customer.pojo
* @date 2017年10月23日 
*/
    
package com.mvne.app.domain;

import org.springframework.stereotype.Component;

/**
* @ClassName: CreateUserInsResponseParam
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zengxf
* @date 2017年10月23日
* @version V1.0  
*/

@Component
public class CreateUserInsResponseParam {
	
	private Integer custId;
	private Integer acctId;
	private Integer subsUserId;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public Integer getSubsUserId() {
		return subsUserId;
	}
	public void setSubsUserId(Integer subsUserId) {
		this.subsUserId = subsUserId;
	}

}
