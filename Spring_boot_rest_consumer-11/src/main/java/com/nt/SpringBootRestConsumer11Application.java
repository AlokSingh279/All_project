package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestConsumer11Application {

	@Bean
	RestTemplate theRest() {
		return new RestTemplate()
;	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestConsumer11Application.class, args);
	}

}
