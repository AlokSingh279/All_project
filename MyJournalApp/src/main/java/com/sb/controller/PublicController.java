package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.Users;
import com.sb.service.userService;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private userService userservice;

	@PostMapping("/create-user")
	public Users createUser(@RequestBody Users user) {
		return userservice.createJournal(user);
	}
}
