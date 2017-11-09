/***********************************************************  
* @Title : CustomerFallback_new.java  
* @Package : com.mvne.app.fallback  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月31日 下午5:11:20  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.fallback;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mvne.app.domain.ChgCmCustPara;
import com.mvne.app.domain.CmCust;
import com.mvne.app.domain.CmPwdProtect;
import com.mvne.app.domain.CmReceiveAddr;
import com.mvne.app.domain.CreateProdInsRequestParam;
import com.mvne.app.domain.CreateUserInsRequestParam;
import com.mvne.app.domain.ReturnData;
import com.mvne.app.domain.SubsUser;
import com.mvne.app.domain.UpdatePwdPara;
import com.mvne.app.service.CustomerService;

import feign.hystrix.FallbackFactory;

/***********************************************************  
* @ClassName : CustomerFallback_new  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月31日 下午5:11:20  
***********************************************************/
@Service
public class CustomerFallback_new implements FallbackFactory<CustomerService> {

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : create</p>  
	* <p>Description: </p>  
	* :@param arg0
	* :@return  
	* :@see feign.hystrix.FallbackFactory#create(java.lang.Throwable)  
	************************************************************/ 
	@Override
	public CustomerService create(Throwable e) {
		// TODO Auto-generated method stub
		return new CustomerService(){

			@Override
			public String test() {
				// TODO Auto-generated method stub
				e.printStackTrace();
				return "error:" + e.getMessage();
			}

			@Override
			public ReturnData saveCmCust(CmCust cmCust) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getAcctBalance(String billId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData chgCmCust(ChgCmCustPara para, String billId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getCmCust(String billId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getPwdprotect(String billId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData chgPwdProtect(String billId, CmPwdProtect cmPwdProctect) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData verifyPwdProtect(CmPwdProtect cmPwdProctect) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData addReceiveAddress(CmReceiveAddr cmReceiveAddr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getReceiveAddr(String custId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData chgReceiveAddr(CmReceiveAddr cmReceiveAddr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData chgReceiveAddr(Integer recieveAddrId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData createUserIns(CreateUserInsRequestParam param) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData createProdIns(CreateProdInsRequestParam param) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData uploadPic(MultipartFile file) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData downloadPic(String id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getUserProd(String billId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData loginVeriry(SubsUser subsUser) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData updateServerPwd(UpdatePwdPara para) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ReturnData getUserInfo(String billId) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
