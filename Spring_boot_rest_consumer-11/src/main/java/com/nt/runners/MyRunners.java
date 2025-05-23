package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	//	RestTemplate template = new RestTemplate();

		String url = "http://localhost:5454/Spring_boot_rest_producer-11/provide/service";

		ResponseEntity<String> response = template.getForEntity(url, String.class);

		System.out.println("::: " + response.getBody());
		System.out.println("::: " + response.getStatusCode());
		
         //system.exit(0);
	}

}
