package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MySpringSecurity1Application {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurity1Application.class, args);
	}

}
