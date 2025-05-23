package com.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {

		UserDetails userDetail = User.withUsername("user").password(passencode().encode("1234")).roles("USER").build();
		UserDetails userDetails = User.withUsername("admin").password(passencode().encode("1234")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(userDetail,userDetails);
	}

	@Bean
	PasswordEncoder passencode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain security(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests().
		anyRequest().authenticated().
		and().formLogin();
		return http.build();
	}
}
