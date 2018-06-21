package com.didispace;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Profile;

//@EnableDiscoveryClient
@SpringBootApplication
public class Application implements InitializingBean{
	
	@Value("${info.from}")
	String profile;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("profile="+profile);
	}

}
