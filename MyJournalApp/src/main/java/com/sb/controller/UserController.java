package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.Users;
import com.sb.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private userService userservice;

	@PutMapping
	public ResponseEntity<?> getUpdated(@RequestBody Users user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String olduser = auth.getName();
		Users indb = userservice.findByName(olduser);
		indb.setUserName(user.getUserName());
		indb.setPassword(user.getPassword());
		userservice.createJournal(indb);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
