package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyRunners2 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		String url = "http://localhost:5454/Spring_boot_rest_producer-11/provide/getting/{id}/{name}";

		String response = template.getForObject(url, String.class, 101, "Alok Singh");

		System.out.println("The response content is" + response);
	}

}
