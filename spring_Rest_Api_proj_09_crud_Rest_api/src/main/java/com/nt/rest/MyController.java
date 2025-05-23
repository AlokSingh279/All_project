package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristService;

@RestController
@RequestMapping("/tourist-api")
public class MyController {

	@Autowired
	private ITouristService service;

	@PostMapping("/insert")
	ResponseEntity<String> regiter(@RequestBody Tourist tourist) {
		try {
			String msg = service.registerTourist(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTourist")
	ResponseEntity<Object> getAllList() {

		try {
			List<Tourist> list = service.getAllTousrist();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	ResponseEntity<Object> receivedByID(@PathVariable int id) {
		try {
			Tourist tourist = service.getById(id);
			return new ResponseEntity<Object>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	ResponseEntity<String> updating(@RequestBody Tourist tourist) {

		try {
			String msg = service.UpdateTourist(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/halfupdate/{id}/{percentage}")
	ResponseEntity<String> halfupdate(@PathVariable int id, @PathVariable float percentage) {

		try {
			String msg = service.partialUpdateTourist(id, percentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Object> touristDelete(@PathVariable int id) {

		try {
			String msg = service.deleteByTourist(id);
			return new ResponseEntity<Object>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
