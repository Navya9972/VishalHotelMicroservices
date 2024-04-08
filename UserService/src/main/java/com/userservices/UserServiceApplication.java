package com.userservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	//add dependency spring boot - starter-webflux
//	@Bean
//	public WebClient webclient()
//	{
//		 return WebClient.builder.build();
//	}
	public static void main(String[] args) {
		
		
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
