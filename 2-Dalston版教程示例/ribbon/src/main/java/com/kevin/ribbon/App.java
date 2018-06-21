package com.kevin.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableCircuitBreaker
public class App {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class).web(true).run(args);
	}

}
