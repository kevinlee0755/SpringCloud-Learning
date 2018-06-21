package com.kevin.hystrix;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

	@Autowired
	StoreIntegration service;
	
	@Value("${server.port}")
	String port;
	
	@GetMapping
	public String get(){
		return port;
	}
	
	@GetMapping("/a/{key}")
	public Object get(@PathVariable String key){
		Object data=null;
		if("1".equals(key)){
			data=service.getStores(null);
		}else{
			data=service.getStores(new HashMap());
		}
		return data;
	}
}
