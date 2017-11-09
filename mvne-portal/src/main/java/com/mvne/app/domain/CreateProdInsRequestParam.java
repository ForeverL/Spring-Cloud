
/**  
* All rights Reserved, Designed By zengxf  
* @Project mvne-customer 
* @File CreateProdInsRequestParam.java
* @Package com.cmsz.mvne.customer.pojo
* @date 2017年10月23日 
*/
    
package com.mvne.app.domain;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
* @ClassName: CreateProdInsRequestParam
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zengxf
* @date 2017年10月23日
* @version V1.0  
*/

@Component
public class CreateProdInsRequestParam {
	
	private SubsProduct subsProduct;
	private List<SubsProductElement> subsProductElementList;	
	private SubsComm subsComm;
	private List<SubsBasicOffer> subsBasicOfferList;
	private List<SubsBasicProd> subsBasicProdList;
	private Date succTime;
	private Integer custId;
	private Integer subsUserId;
	
	public SubsProduct getSubsProduct() {
		return subsProduct;
	}
	public void setSubsProduct(SubsProduct subsProduct) {
		this.subsProduct = subsProduct;
	}
	public List<SubsProductElement> getSubsProductElementList() {
		return subsProductElementList;
	}
	public void setSubsProductElementList(List<SubsProductElement> subsProductElementList) {
		this.subsProductElementList = subsProductElementList;
	}
	public SubsComm getSubsComm() {
		return subsComm;
	}
	public void setSubsComm(SubsComm subsComm) {
		this.subsComm = subsComm;
	}
	public List<SubsBasicOffer> getSubsBasicOfferList() {
		return subsBasicOfferList;
	}
	public void setSubsBasicOfferList(List<SubsBasicOffer> subsBasicOfferList) {
		this.subsBasicOfferList = subsBasicOfferList;
	}
	public List<SubsBasicProd> getSubsBasicProdList() {
		return subsBasicProdList;
	}
	public void setSubsBasicProdList(List<SubsBasicProd> subsBasicProdList) {
		this.subsBasicProdList = subsBasicProdList;
	}
	public Date getSuccTime() {
		return succTime;
	}
	public void setSuccTime(Date succTime) {
		this.succTime = succTime;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getSubsUserId() {
		return subsUserId;
	}
	public void setSubsUserId(Integer subsUserId) {
		this.subsUserId = subsUserId;
	}

}
