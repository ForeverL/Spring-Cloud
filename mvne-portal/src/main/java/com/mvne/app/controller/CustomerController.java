/***********************************************************  
* @Title : CustomerController.java  
* @Package : com.mvne.app.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午10:05:47  
* @version : V1.0  
***********************************************************/
package com.mvne.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mvne.app.domain.ChgCmCustPara;
import com.mvne.app.domain.CmAcct;
import com.mvne.app.domain.CmCust;
import com.mvne.app.domain.CmPwdProtect;
import com.mvne.app.domain.CmReceiveAddr;
import com.mvne.app.domain.CreateProdInsRequestParam;
import com.mvne.app.domain.CreateUserInsRequestParam;
import com.mvne.app.domain.ReturnData;
import com.mvne.app.domain.SubsProduct;
import com.mvne.app.domain.SubsUser;
import com.mvne.app.domain.UpdatePwdPara;
import com.mvne.app.service.CustomerService;

/***********************************************************
 * @ClassName : CustomerController
 * @Description : TODO(这里用一句话描述这个类的作用)
 * @author :Hanson
 * @date :2017年10月29日 上午10:05:47
 ***********************************************************/

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	// 保存用户实名认证信息，返回用户待认证ID
	@RequestMapping(value = "/saveCmCust", method = RequestMethod.POST)
	public ReturnData saveCmCust(@RequestBody CmCust cmCust) {
		ReturnData rd = customerService.saveCmCust(cmCust);
		/*if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof CmCust)) {
			CmCust cc = ((CmCust) rd.getReturnObject());
			LOGGER.info(cc.getCertNum() + cc.getCertNum());
		} else {
			LOGGER.warn("Object is null!");
		}*/
		
		//CmCust cc = ((CmCust) rd.getReturnObject());
		LOGGER.info(rd.getCode() + rd.getMessage());

		return rd;
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(){
		LOGGER.info("test....");
		String str = customerService.test();
		LOGGER.info(str);
		return str;
	}

	// 上传图片接口，返回图片URL
	@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	public ReturnData uploadPic(@RequestParam("imageFile") MultipartFile file) {
		
		LOGGER.info("start upload picture...");
		if(!file.isEmpty()){
			LOGGER.info("file is not empty!" + file.getName() + file.getOriginalFilename());
			try {
				file.transferTo(new File("aaa.jpg"));
				LOGGER.info("save file success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		ReturnData rd = customerService.uploadPic(file);
		
		LOGGER.info("upload pic success!!!");
		//LOGGER.info(rd.toString());
		LOGGER.info(rd.getCode() + rd.getMessage());
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			String imgUrl = (String) rd.getReturnObject();
			LOGGER.info(imgUrl);
		} else {
			LOGGER.warn("Object is null!");
		}

		return rd;
	}

	// 返回新增收货地址状态码和状态信息。
	@RequestMapping(value = "/addReceiveAddress", method = RequestMethod.POST)
	public ReturnData addReceiveAddress(@RequestBody CmReceiveAddr cmReceiveAddr) {
		ReturnData rd = customerService.addReceiveAddress(cmReceiveAddr);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入用户电话号码,获取用户余额
	@RequestMapping(value = "/getAcctBalance/{billId}", method = RequestMethod.GET)
	public ReturnData getAcctBalance(@PathVariable("billId") String billId) {
		ReturnData rd = customerService.getAcctBalance(billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof CmAcct)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
			CmAcct ca = (CmAcct) rd.getReturnObject();
			LOGGER.info(ca.getBillId());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 修改客户信息,返回更新客户信息的状态码和信息
	@RequestMapping(value = "/chgCmCust/{billId}", method = RequestMethod.PUT)
	public ReturnData chgCmCust(@RequestBody ChgCmCustPara para, @PathVariable("billId") String billId) {
		ReturnData rd = customerService.chgCmCust(para, billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 获取客户信息，返回客户对象
	@RequestMapping(value = "/getCmCust/{billId}", method = RequestMethod.GET)
	public ReturnData getCmCust(@PathVariable("billId") String billId) {
		ReturnData rd = customerService.getCmCust(billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof CmCust)) {
			CmCust cc = ((CmCust) rd.getReturnObject());
			LOGGER.info(cc.getCustName());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入参数，获取密保
	@RequestMapping(value = "/getPwdProtect/{billId}", method = RequestMethod.GET)
	public ReturnData getPwdprotect(@PathVariable("billId") String billId) {
		ReturnData rd = customerService.getPwdprotect(billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof CmPwdProtect)) {
			CmPwdProtect cpp = (CmPwdProtect) rd.getReturnObject();
			LOGGER.info(cpp.getFirstAnswer() + cpp.getFirstQuestion());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 修改密保，返回状态码和信息
	@RequestMapping(value = "/chgPwdProtect/{billId}", method = RequestMethod.PUT)
	public ReturnData chgPwdProtect(@PathVariable("billId") String billId, @RequestBody CmPwdProtect cmPwdProctect) {
		ReturnData rd = customerService.chgPwdProtect(billId, cmPwdProctect);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 校验密保，返回状态码和信息
	@RequestMapping(value = "/verifyPwdProtect", method = RequestMethod.POST)
	public ReturnData verifyPwdProtect(@RequestBody CmPwdProtect cmPwdProctect) {
		ReturnData rd = customerService.verifyPwdProtect(cmPwdProctect);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 根据custId获取收货地址
	@RequestMapping(value = "/getReceiveAddr/{custId}", method = RequestMethod.GET)
	public ReturnData getReceiveAddr(@PathVariable("custId") String custId) {
		ReturnData rd = customerService.getReceiveAddr(custId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof CmReceiveAddr)) {
			CmReceiveAddr cra = (CmReceiveAddr) rd.getReturnObject();
			LOGGER.info(cra.getReceiveName() + cra.getReceiveAddr());
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 修改收货地址，返回状态码和信息
	@RequestMapping(value = "/chgReceiveAddr", method = RequestMethod.PUT)
	public ReturnData chgReceiveAddr(@RequestBody CmReceiveAddr cmReceiveAddr) {
		ReturnData rd = customerService.chgReceiveAddr(cmReceiveAddr);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 删除收获地址，返回状态码和信息
	@RequestMapping(value = "/delReceiveAddr/{recieveAddrId}", method = RequestMethod.PUT)
	public ReturnData chgReceiveAddr(@PathVariable("recieveAddrId") Integer recieveAddrId) {
		ReturnData rd = customerService.chgReceiveAddr(recieveAddrId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入参数，创建用户三户信息，返回状态码和信息
	@RequestMapping(value = "/createUserIns", method = RequestMethod.POST)
	public ReturnData createUserIns(@RequestBody CreateUserInsRequestParam param) {
		ReturnData rd = customerService.createUserIns(param);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入参数，生成产品实例关系实例，返回状态码和信息
	@RequestMapping(value = "/createProdIns", method = RequestMethod.POST)
	public ReturnData createProdIns(@RequestBody CreateProdInsRequestParam param) {
		ReturnData rd = customerService.createProdIns(param);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 图片下载，返回状态码和信息
	@RequestMapping(value = "/downloadPic/{picId}", method = RequestMethod.GET)
	public ReturnData downloadPic(@PathVariable("picId") String id) {
		ReturnData rd = customerService.downloadPic(id);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入手机号，获取用户订购信息，
	@RequestMapping(value = "/getUserProd/{billId}", method = RequestMethod.GET)
	public ReturnData getUserProd(@PathVariable("billId") String billId) {
		ReturnData rd = customerService.getUserProd(billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof SubsProduct)) {
			List<SubsProduct> productList = (List<SubsProduct>) customerService.getUserProd(billId);
			LOGGER.info(rd.getCode() + rd.getMessage());
			for (SubsProduct subsProduct : productList) {
				LOGGER.info(subsProduct.getProductName());
			}
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入手机号,登录校验
	@RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
	public ReturnData loginVeriry(@RequestBody SubsUser subsUser) {
		ReturnData rd = customerService.loginVeriry(subsUser);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof SubsUser)) {
			SubsUser sbu = (SubsUser) rd.getReturnObject();
			LOGGER.info(rd.getCode() + rd.getMessage());
			LOGGER.info(sbu.getBillId());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	//修改服务密码，返回状态码和信息
	@RequestMapping(value = "/updateServerPwd", method = RequestMethod.PUT)
	public ReturnData updateServerPwd(@RequestBody UpdatePwdPara para) {
		ReturnData rd = customerService.updateServerPwd(para);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

	// 输入参数，获取用户信息，返回状态码和信息
	@RequestMapping(value = "/getUserInfo/{billId}", method = RequestMethod.GET)
	public ReturnData getUserInfo(@PathVariable("billId") String billId) {
		ReturnData rd = customerService.getUserInfo(billId);
		if ((rd.getReturnObject() != null) && (rd.getReturnObject() instanceof String)) {
			LOGGER.info(rd.getCode() + rd.getMessage());
		} else {
			LOGGER.warn("Object is null!");
		}
		return rd;
	}

}
