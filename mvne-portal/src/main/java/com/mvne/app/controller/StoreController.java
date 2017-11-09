/***********************************************************  
* @Title : StoreController.java  
* @Package : com.mvne.app.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午10:05:25  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvne.app.domain.QueryNumberObject;
import com.mvne.app.domain.ReturnResultObject;
import com.mvne.app.domain.UsableNumberObject;
import com.mvne.app.service.StoreService;

/***********************************************************  
* @ClassName : StoreController  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:05:25  
***********************************************************/
@RestController
//@RequestMapping("/store")
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	
	@Autowired
	private StoreService repService;
	
	
	//选号
	@RequestMapping(value="/getPhoneNum",method = RequestMethod.POST)
	public UsableNumberObject getPhone(@RequestBody QueryNumberObject phoneNum) {
		//logger.info(phoneNum.getPhoneNum());
		
		
		UsableNumberObject uno = repService.getPhoneNum(phoneNum);
		//if(uno)
		if(uno.getAllNumberNum() == 0){
			logger.warn("query 0 number");
		}
		logger.info(uno.getDesc() +"##"+ uno.getAllNumberNum() +"##"+ uno.getCurrentPage() +"##"+ uno.getPageSize()
				+"##"+ uno.getTotalPage());
		logger.info("查询到的号码：" + uno.getNumbers().toString());
		return uno;
	}
	
	//号码锁定，状态确认
	@RequestMapping(value="/LockAffirm",method = RequestMethod.POST)
	public ReturnResultObject LockAffirm(@RequestParam(value="bill_id") String bill_id) {
		//logger.info(phoneNum.getPhoneNum());
		ReturnResultObject rro = repService.LockAffirm(bill_id);
		logger.info(rro.getRetcode()+rro.getRetdesc());
		return rro;
	}
	
	//号码预占
	@RequestMapping(value="/preOccupyNumber",method=RequestMethod.POST)
	public ReturnResultObject PreOccupy(@RequestParam(value="bill_id") String bill_id){
		
		logger.info("####################"+bill_id);
		ReturnResultObject rro = repService.PreOccupy(bill_id);
		logger.info(rro.getRetcode()+rro.getRetdesc());
		return rro;
	}
	
	
	@GetMapping("/test")
	public String test() {
		logger.info("test stockCenter log");
		return repService.test();
	}
	
}
