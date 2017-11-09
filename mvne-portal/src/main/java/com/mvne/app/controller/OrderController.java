package com.mvne.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvne.app.domain.Order;
import com.mvne.app.service.OrderService;
import com.mvne.app.service.StoreService;

/***********************************************************  
* @ClassName : OrderController  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:11:53  
***********************************************************/ 
@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private StoreService storeService;

	
	// 订单提交
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String addOrder(@RequestParam(value="bill_id") String bill_id,@RequestBody Order order) {
		
		//logger.info(orderService.addOrder(order));
		
		if(storeService.PreOccupy(order.getPhoneNum()).getRetcode().equals("0000")){
			return orderService.addOrder(order);
		}
		
		logger.info("add order.....");
		return "ERROR";
		
	}

}
