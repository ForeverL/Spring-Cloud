/***********************************************************  
* @Title : CustomerService.java  
* @Package : com.mvne.app.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午9:53:50  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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



/***********************************************************  
* @ClassName : CustomerService  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午9:53:50  
***********************************************************/

@FeignClient(name="mvne-customer",fallbackFactory=com.mvne.app.fallback.CustomerFallback_new.class)
public interface CustomerService {
	
	@RequestMapping(value="/customer/test", method=RequestMethod.GET)
	public String test();

	
	@RequestMapping(value="/customer/saveCmCust", method=RequestMethod.POST)
	public ReturnData saveCmCust(@RequestBody CmCust cmCust);
	
	@RequestMapping(value="/customer/getAcctBalance/{billId}",method=RequestMethod.GET)
	public ReturnData getAcctBalance(@PathVariable("billId") String billId);
	
	
	@RequestMapping(value = "/customer/chgCmCust/{billId}",method = RequestMethod.PUT)
	public ReturnData chgCmCust(@RequestBody ChgCmCustPara para,@PathVariable("billId") String billId);
	
	@RequestMapping(value = "/customer/getCmCust/{billId}",method = RequestMethod.GET)
	public ReturnData getCmCust(@PathVariable("billId") String billId);
	
	@RequestMapping(value = "/customer/getPwdProtect/{billId}",method = RequestMethod.GET)
	public ReturnData getPwdprotect(@PathVariable("billId") String billId);
	
	@RequestMapping(value = "/customer/chgPwdProtect/{billId}",method = RequestMethod.PUT)
	public ReturnData chgPwdProtect(@PathVariable("billId") String billId,@RequestBody CmPwdProtect cmPwdProctect);
	
	@RequestMapping(value = "/customer/verifyPwdProtect",method = RequestMethod.POST)
	public ReturnData verifyPwdProtect(@RequestBody CmPwdProtect cmPwdProctect);
	
	@RequestMapping(value = "/customer/addReceiveAddress",method = RequestMethod.POST)
	public ReturnData addReceiveAddress(@RequestBody CmReceiveAddr cmReceiveAddr);
	
	@RequestMapping(value = "/customer/getReceiveAddr/{custId}",method = RequestMethod.GET)
	public ReturnData getReceiveAddr(@PathVariable("custId") String custId);
	
	@RequestMapping(value = "/customer/chgReceiveAddr",method = RequestMethod.PUT)
	public ReturnData chgReceiveAddr(@RequestBody CmReceiveAddr cmReceiveAddr);
	
	@RequestMapping(value = "/customer/delReceiveAddr/{recieveAddrId}",method = RequestMethod.PUT)
	public ReturnData chgReceiveAddr(@PathVariable("recieveAddrId") Integer recieveAddrId);
	
	
	@RequestMapping(value="/customer/createUserIns" , method=RequestMethod.POST)
	public ReturnData createUserIns(@RequestBody CreateUserInsRequestParam param);
	
	@RequestMapping(value="/customer/createProdIns", method=RequestMethod.POST)
	public ReturnData createProdIns(@RequestBody CreateProdInsRequestParam param);
	
	@RequestMapping(value = "/customer/uploadPic", method = RequestMethod.POST)
	public ReturnData uploadPic(@RequestParam("imageFile") MultipartFile file);
	
	@RequestMapping(value = "/customer/downloadPic/{picId}", method = RequestMethod.GET)
	public ReturnData downloadPic(@PathVariable("picId") String id);
	
	@RequestMapping(value="/customer/getUserProd/{billId}",method=RequestMethod.GET)
	public ReturnData getUserProd(@PathVariable("billId") String billId);
	
	@RequestMapping(value = "/customer/loginVerify",method = RequestMethod.POST)
	public ReturnData loginVeriry(@RequestBody SubsUser subsUser);
	
	@RequestMapping(value="/customer/updateServerPwd",method=RequestMethod.PUT)
	public ReturnData updateServerPwd(@RequestBody UpdatePwdPara para);
	
	@RequestMapping(value = "/customer/getUserInfo/{billId}",method = RequestMethod.GET)
	public ReturnData getUserInfo(@PathVariable("billId") String billId);
	
}
