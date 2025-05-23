package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/report/{cno}/{cname}")
	ResponseEntity<String> showReport(@PathVariable("cno") int no, @PathVariable String cname) {
		System.out.println(no + "........." + cname);

		return new ResponseEntity<String>(no + "......" + cname, HttpStatus.OK);

	}

	/*
	 * @GetMapping("/report/{cno}/{cname}") ResponseEntity<String>
	 * showReport(@PathVariable("cno") String no, @PathVariable String cname) {
	 * System.out.println(no + "........." + cname);
	 * 
	 * return new ResponseEntity<String>(no + "......" + cname, HttpStatus.OK);
	 * 
	 * }
	 */

	/*
	 * @GetMapping({"/report/{cno}/{cname}","/report/{cno}"}) ResponseEntity<String>
	 * showReport(@PathVariable("cno") String no, @PathVariable(required=false)
	 * String cname) { System.out.println(no + "........." + cname);
	 * 
	 * return new ResponseEntity<String>(no + "......" + cname, HttpStatus.OK);
	 * 
	 * }
	 */
}
