package com.kevin.hystrix;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class App implements InitializingBean {
	
	@Autowired
	private StoreIntegration service;

	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class).web(false).run(args);
	}

	public void afterPropertiesSet() throws Exception {
		Object data=service.getStores(null);
		System.out.println(data);
	}
}
