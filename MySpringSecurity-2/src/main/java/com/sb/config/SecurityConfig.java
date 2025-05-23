package com.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userService() {
		return new MyCustomUserServiceDetail();
	}

	@Bean
	DaoAuthenticationProvider daoAuthenticate() {
		DaoAuthenticationProvider authen = new DaoAuthenticationProvider();
		authen.setUserDetailsService(userService());
		authen.setPasswordEncoder(encoder());
		return authen;
	}

	@Bean
	SecurityFilterChain chain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests().requestMatchers("/index").permitAll().anyRequest().authenticated()
				.and().formLogin();

		return http.build();

	}
}
