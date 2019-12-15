package com.docker.springconsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringConsumeApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringConsumeApplication.class);
	
	public static void main(String[] args) {
		log.info("started--->");;
		SpringApplication.run(SpringConsumeApplication.class, args);
	}
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

}
