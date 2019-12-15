package com.docker.springconsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumeService {
		
	@Autowired
	private RestTemplate restTemplate;
	
	private final Logger log = LoggerFactory.getLogger(ConsumeService.class);
	
	public String getValueFromOtherService(){
		
		String result = "";
		String dockerUrl = "http://restproducer:8080/hi";
		String url = "http://localhost:8080/hi";
		
		url = dockerUrl;
		result = restTemplate.getForObject(url, String.class);
		log.info("received from " + url + " result=" + result);
		
		return result;
		
	}
	
	

}
