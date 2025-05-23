package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.Users;
import com.sb.service.userService;

@RestController
@RequestMapping("/admin")
public class MyAdmin {

	@Autowired
	private userService userservice;

	@GetMapping("/all-user")
	public ResponseEntity<?> allUser() {

		List<Users> all = userservice.geatAll();
		if (all != null || all.isEmpty()) {

			return new ResponseEntity<>(all, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PostMapping("/create-new-admin")
	public void createUser(@RequestBody Users user) {
		userservice.createAdminUser(user);
	}
}
