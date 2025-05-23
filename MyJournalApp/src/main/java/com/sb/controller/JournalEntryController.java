package com.sb.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.JournalEntry;
import com.sb.entity.Users;
import com.sb.service.JournalEntryService;
import com.sb.service.userService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	@Autowired
	private JournalEntryService service;

	@Autowired
	private userService userservice;

	@PostMapping("/create")
	public ResponseEntity<JournalEntry> insertJournal(@RequestBody JournalEntry entry) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		service.createJournal(entry, name);
		return new ResponseEntity<JournalEntry>(entry, HttpStatus.CREATED);

	}

	@GetMapping("/get")
	public List<JournalEntry> list() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Users users = userservice.findByName(name);
		List<JournalEntry> oldlist = users.getList();
		// service.geatAll();
		return oldlist;
	}

	@GetMapping("/onlyget/{id}")
	public ResponseEntity<JournalEntry> getJournal(@PathVariable ObjectId id) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Users users = userservice.findByName(name);
		List<JournalEntry> list = users.getList().stream().filter(x -> x.getId().equals(id))
				.collect(Collectors.toList());
		if (!list.isEmpty()) {
			JournalEntry old = service.getJournalById(id).orElse(null);
			return new ResponseEntity<JournalEntry>(old, HttpStatus.OK);
		}

		return new ResponseEntity<JournalEntry>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> journaldelte(@PathVariable ObjectId id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		service.deleteJournalById(id, name);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/updated/{id}")
	public ResponseEntity<JournalEntry> updated(@PathVariable ObjectId id, @RequestBody JournalEntry entry) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Users users = userservice.findByName(name);
		List<JournalEntry> list = users.getList().stream().filter(x -> x.getId().equals(id))
				.collect(Collectors.toList());
		if (!list.isEmpty()) {
			JournalEntry old = service.getJournalById(id).orElse(null);
			old.setName(entry.getName());
			old.setContent(entry.getContent());
			service.createJournal(old);
			return new ResponseEntity<JournalEntry>(old, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<JournalEntry>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
