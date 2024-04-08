package com.userservices.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigApplication {

	@Bean
	@LoadBalanced
	//y because we use lb so that in userserviceimpl class  wen we use resttemple .forobject(in url i want to 
	//give application name instead of port number ) sooo
   public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
