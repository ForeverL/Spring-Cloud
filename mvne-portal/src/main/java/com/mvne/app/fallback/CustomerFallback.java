/***********************************************************  
* @Title : CustomerFallback.java  
* @Package : com.mvne.app.fallback  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午10:22:15  
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

/***********************************************************  
* @ClassName : CustomerFallback  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:22:15  
***********************************************************/

@Service
public class CustomerFallback implements CustomerService {

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : saveCmCust</p>  
	* <p>Description: </p>  
	* :@param cmCust
	* :@return  
	* :@see com.mvne.app.service.CustomerService#saveCmCust(com.mvne.app.domain.customer.CmCust)  
	************************************************************/ 
	@Override
	public ReturnData saveCmCust(CmCust cmCust) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getAcctBalance</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getAcctBalance(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData getAcctBalance(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : chgCmCust</p>  
	* <p>Description: </p>  
	* :@param para
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#chgCmCust(com.mvne.app.domain.customer.ChgCmCustPara, java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData chgCmCust(ChgCmCustPara para, String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getCmCust</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getCmCust(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData getCmCust(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getPwdprotect</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getPwdprotect(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData getPwdprotect(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : chgPwdProtect</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@param cmPwdProctect
	* :@return  
	* :@see com.mvne.app.service.CustomerService#chgPwdProtect(java.lang.String, com.mvne.app.domain.customer.CmPwdProtect)  
	************************************************************/ 
	@Override
	public ReturnData chgPwdProtect(String billId, CmPwdProtect cmPwdProctect) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : verifyPwdProtect</p>  
	* <p>Description: </p>  
	* :@param cmPwdProctect
	* :@return  
	* :@see com.mvne.app.service.CustomerService#verifyPwdProtect(com.mvne.app.domain.customer.CmPwdProtect)  
	************************************************************/ 
	@Override
	public ReturnData verifyPwdProtect(CmPwdProtect cmPwdProctect) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : addReceiveAddress</p>  
	* <p>Description: </p>  
	* :@param cmReceiveAddr
	* :@return  
	* :@see com.mvne.app.service.CustomerService#addReceiveAddress(com.mvne.app.domain.customer.CmReceiveAddr)  
	************************************************************/ 
	@Override
	public ReturnData addReceiveAddress(CmReceiveAddr cmReceiveAddr) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getReceiveAddr</p>  
	* <p>Description: </p>  
	* :@param custId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getReceiveAddr(java.lang.Integer)  
	************************************************************/ 
	@Override
	public ReturnData getReceiveAddr(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : chgReceiveAddr</p>  
	* <p>Description: </p>  
	* :@param cmReceiveAddr
	* :@return  
	* :@see com.mvne.app.service.CustomerService#chgReceiveAddr(com.mvne.app.domain.customer.CmReceiveAddr)  
	************************************************************/ 
	@Override
	public ReturnData chgReceiveAddr(CmReceiveAddr cmReceiveAddr) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : chgReceiveAddr</p>  
	* <p>Description: </p>  
	* :@param recieveAddrId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#chgReceiveAddr(java.lang.Integer)  
	************************************************************/ 
	@Override
	public ReturnData chgReceiveAddr(Integer recieveAddrId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : createUserIns</p>  
	* <p>Description: </p>  
	* :@param param
	* :@return  
	* :@see com.mvne.app.service.CustomerService#createUserIns(com.mvne.app.domain.customer.CreateUserInsRequestParam)  
	************************************************************/ 
	@Override
	public ReturnData createUserIns(CreateUserInsRequestParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : createProdIns</p>  
	* <p>Description: </p>  
	* :@param param
	* :@return  
	* :@see com.mvne.app.service.CustomerService#createProdIns(com.mvne.app.domain.customer.CreateProdInsRequestParam)  
	************************************************************/ 
	@Override
	public ReturnData createProdIns(CreateProdInsRequestParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : uploadPic</p>  
	* <p>Description: </p>  
	* :@param file
	* :@return  
	* :@see com.mvne.app.service.CustomerService#uploadPic(org.springframework.web.multipart.MultipartFile)  
	************************************************************/ 
	@Override
	public ReturnData uploadPic(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : downloadPic</p>  
	* <p>Description: </p>  
	* :@param id
	* :@return  
	* :@see com.mvne.app.service.CustomerService#downloadPic(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData downloadPic(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getUserProd</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getUserProd(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData getUserProd(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : loginVeriry</p>  
	* <p>Description: </p>  
	* :@param subsUser
	* :@return  
	* :@see com.mvne.app.service.CustomerService#loginVeriry(com.mvne.app.domain.customer.SubsUser)  
	************************************************************/ 
	@Override
	public ReturnData loginVeriry(SubsUser subsUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : updateServerPwd</p>  
	* <p>Description: </p>  
	* :@param para
	* :@return  
	* :@see com.mvne.app.service.CustomerService#updateServerPwd(com.mvne.app.domain.customer.UpdatePwdPara)  
	************************************************************/ 
	@Override
	public ReturnData updateServerPwd(UpdatePwdPara para) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getUserInfo</p>  
	* <p>Description: </p>  
	* :@param billId
	* :@return  
	* :@see com.mvne.app.service.CustomerService#getUserInfo(java.lang.String)  
	************************************************************/ 
	@Override
	public ReturnData getUserInfo(String billId) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : test</p>  
	* <p>Description: </p>  
	* :@return  
	* :@see com.mvne.app.service.CustomerService#test()  
	************************************************************/ 
	@Override
	public String test() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
