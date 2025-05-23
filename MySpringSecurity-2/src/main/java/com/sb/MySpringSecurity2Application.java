package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MySpringSecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurity2Application.class, args);
	}

}
