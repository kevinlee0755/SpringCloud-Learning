package com.kevin.ribbon;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

	@Autowired
    private LoadBalancerClient loadBalancer;

	@GetMapping
    public Map doStuff() throws IOException {
        ServiceInstance instance = loadBalancer.choose("store");
        //URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        URL url=instance.getUri().toURL();
        InputStream is=url.openStream();
        try{
        	
        	String str=StreamUtils.copyToString(is, Charset.defaultCharset());
        	Map data=new HashMap<String,Object>();
        	data.put("url", instance.getUri().toString());
        	data.put("data", str);
        	return data;
        }finally {
        	is.close();
        }
        // ... do something with the URI
    }
	

}
