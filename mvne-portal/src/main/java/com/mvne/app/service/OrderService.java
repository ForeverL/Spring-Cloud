package com.mvne.app.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvne.app.domain.Order;




/***********************************************************  
* @ClassName : OrderService  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:06:53  
***********************************************************/ 
@FeignClient(name="mvne-order",fallback=com.mvne.app.fallback.OrderFallback.class)
public interface OrderService {

	@RequestMapping(value="/addOrder",method = RequestMethod.POST)
	public String addOrder(Order order);
}
