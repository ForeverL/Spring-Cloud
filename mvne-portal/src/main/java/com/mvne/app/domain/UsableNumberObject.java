/**
 * 
 */
package com.mvne.app.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author jiangxm
 * 符合查询条件的可用号码结果对象，包括
 */
@Component
public class UsableNumberObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6981004264750342256L;
	private String RetCode;       //响应状态码
	private String Desc;         //响应状态描述
	private long AllNumberNum;   //查询到的号码总数
	private int TotalPage;       //总页数
	private int CurrentPage;      //当前第几页
	private int PageSize;         //每页显示几条记录
	private List<String> numbers;  //号码列表
	
	public UsableNumberObject() {
		super();
	}

	public UsableNumberObject(String retCode, String desc, long allNumberNum, int totalPage, int currentPage,
			int pageSize, List<String> numbers) {
		super();
		RetCode = retCode;
		Desc = desc;
		AllNumberNum = allNumberNum;
		TotalPage = totalPage;
		CurrentPage = currentPage;
		PageSize = pageSize;
		this.numbers = numbers;
	}

	public UsableNumberObject(String retCode, String desc) {
		super();
		RetCode = retCode;
		Desc = desc;
	}

	public String getRetCode() {
		return RetCode;
	}

	public void setRetCode(String retCode) {
		RetCode = retCode;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public long getAllNumberNum() {
		return AllNumberNum;
	}

	public void setAllNumberNum(long allNumberNum) {
		AllNumberNum = allNumberNum;
	}

	public int getTotalPage() {
		return TotalPage;
	}

	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}

	public int getCurrentPage() {
		return CurrentPage;
	}

	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}
}
