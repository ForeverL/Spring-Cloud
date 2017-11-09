/**
 * 
 */
package com.mvne.app.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author jiangxm
 * 用于作为查询可用号码的封装对象，将库存中心需要的7个参数封装成一个QueryNumber对象
 */
@Component
public class QueryNumberObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6417127738185155312L;
	private String provCode;
	private String cityCode;
	private String billId_class;
	private int pageNum;
	private int pageSize;
	private String mvno_id;
	private String mno_id;
	
	public QueryNumberObject() {
		super();
	}

	public QueryNumberObject(String provCode, String cityCode, String billId_class, int pageNum, int pageSize, String mvno_id,
			String mno_id) {
		super();
		this.provCode = provCode;
		this.cityCode = cityCode;
		this.billId_class = billId_class;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.mvno_id = mvno_id;
		this.mno_id = mno_id;
	}

	public String getProvCode() {
		return provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getBillId_class() {
		return billId_class;
	}

	public void setBillId_class(String billId_class) {
		this.billId_class = billId_class;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getMvno_id() {
		return mvno_id;
	}

	public void setMvno_id(String mvno_id) {
		this.mvno_id = mvno_id;
	}

	public String getMno_id() {
		return mno_id;
	}

	public void setMno_id(String mno_id) {
		this.mno_id = mno_id;
	}

	@Override
	public String toString() {
		return "QueryNumberObject [provCode=" + provCode + ", cityCode=" + cityCode + ", BillId_class=" + billId_class
				+ ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", mvno_id=" + mvno_id + ", mno_id=" + mno_id
				+ "]";
	}
}
