package com.nt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provide")
public class MyProviderController {

	@GetMapping("/service")
	ResponseEntity<String> provide() {
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}

	@GetMapping("/getting/{id}/{name}")
	ResponseEntity<String> followingService(@PathVariable int id, @PathVariable String name) {

		return new ResponseEntity<String>(id + "......." + name, HttpStatus.OK);

	}
}
