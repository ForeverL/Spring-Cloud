package com.mvne.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/***********************************************************  
* @ClassName : MvnePortalApplication  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 上午10:07:36  
***********************************************************/ 
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MvnePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvnePortalApplication.class, args);
	}
}
