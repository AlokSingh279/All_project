package com.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/index")
	String index() {
		return "index";
	}

	@GetMapping("/about")
	String about() {
		return "about";
	}

	@GetMapping("/home")
	String home() {
		return "home";
	}
}
