package com.kevin.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
    	if(parameters==null)
    		throw new RuntimeException("¥÷¥¡¡À");
//    	if(1==1)
        return "hello";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "default info";
    }
}
