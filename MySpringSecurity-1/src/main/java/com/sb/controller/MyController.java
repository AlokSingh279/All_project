package com.sb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	
	@RequestMapping("/")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/home")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String home() {
		return "home";
	}
	@RequestMapping("/about")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String about() {
		return "about";
	}
}
