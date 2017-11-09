/***********************************************************  
* @Title : OrderFallback.java  
* @Package : com.mvne.app.fallback  
* @Description: TODO(用一句话描述该文件做什么)  
* @author : Hanson  
* @date :2017年10月29日 上午10:22:00  
* @version : V1.0  
***********************************************************/ 
package com.mvne.app.fallback;

import org.springframework.stereotype.Service;

import com.mvne.app.domain.Order;
import com.mvne.app.service.OrderService;

/***********************************************************  
* @ClassName : OrderFallback  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:22:00  
***********************************************************/
@Service
public class OrderFallback implements OrderService {

	/************************************************************ 
	* (非 Javadoc)  
	* <p>Title : addOrder</p>  
	* <p>Description: </p>  
	* :@param order
	* :@return  
	* :@see com.mvne.app.service.OrderService#addOrder(com.mvne.app.domain.Order)  
	************************************************************/
	@Override
	public String addOrder(Order order) {
		// TODO Auto-generated method stub
		return "调用订单服务失败";
	}

}
