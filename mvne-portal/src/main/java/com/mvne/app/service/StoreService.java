/***********************************************************  
* @Title : StoreService.java  
* @Package : com.mvne.app.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午9:53:20  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvne.app.domain.QueryNumberObject;
import com.mvne.app.domain.ReturnResultObject;
import com.mvne.app.domain.UsableNumberObject;




/***********************************************************  
* @ClassName : StoreService  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午9:53:20  
***********************************************************/

@FeignClient(name="mvne-store",fallback=com.mvne.app.fallback.StoreFallback.class)
public interface StoreService {

	@RequestMapping(value="/Mvne_store/chooseNumber/qryNum",method = RequestMethod.POST)
	public UsableNumberObject getPhoneNum(QueryNumberObject phoneNum);
	
	@RequestMapping(value="/Mvne_store/chooseNumber/lockNumber",method = RequestMethod.POST)
	public ReturnResultObject LockAffirm(@RequestParam(value="bill_id") String bill_id);
	
	@RequestMapping(value="/Mvne_store/chooseNumber/test",method = RequestMethod.GET)
	public String test();
	
	@RequestMapping(value="/Mvne_store/chooseNumber/preOccupyNumber",method=RequestMethod.POST)
	public ReturnResultObject PreOccupy(@RequestParam(value="bill_id") String bill_id);
}
