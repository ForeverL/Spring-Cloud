/***********************************************************  
* @Title : StoreFallback.java  
* @Package : com.mvne.app.fallback  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午10:21:08  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.fallback;

import org.springframework.stereotype.Service;

import com.mvne.app.domain.QueryNumberObject;
import com.mvne.app.domain.ReturnResultObject;
import com.mvne.app.domain.UsableNumberObject;
import com.mvne.app.service.StoreService;

/***********************************************************  
* @ClassName : StoreFallback  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:21:08  
***********************************************************/
@Service
public class StoreFallback implements StoreService {
	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : getPhoneNum</p>  
	* <p>Description: </p>  
	* :@param phoneNum
	* :@return  
	* :@see com.mvne.app.service.StoreService#getPhoneNum(com.mvne.app.domain.QueryNumberObject)  
	************************************************************/
	@Override
	public UsableNumberObject getPhoneNum(QueryNumberObject phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : LockAffirm</p>  
	* <p>Description: </p>  
	* :@param bill_id
	* :@return  
	* :@see com.mvne.app.service.StoreService#LockAffirm(java.lang.String)  
	************************************************************/
	@Override
	public ReturnResultObject LockAffirm(String bill_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : test</p>  
	* <p>Description: </p>  
	* :@return  
	* :@see com.mvne.app.service.StoreService#test()  
	************************************************************/
	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "调用服务失败";
	}

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : PreOccupy</p>  
	* <p>Description: </p>  
	* :@param bill_id
	* :@return  
	* :@see com.mvne.app.service.StoreService#PreOccupy(java.lang.String)  
	************************************************************/
	@Override
	public ReturnResultObject PreOccupy(String bill_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
