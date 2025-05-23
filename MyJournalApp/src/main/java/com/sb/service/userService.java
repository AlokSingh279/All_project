package com.sb.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sb.entity.Users;
import com.sb.repository.userRepo;

@Component
public class userService {

	@Autowired
	private userRepo repo;

	public static final PasswordEncoder encoder = new BCryptPasswordEncoder();

	public Users createJournal(Users entry) {
		entry.setPassword(encoder.encode(entry.getPassword()));
		entry.setRoles(Arrays.asList("USER"));
		return repo.save(entry);
	}
	
	public Users createAdminUser(Users entry) {
		entry.setPassword(encoder.encode(entry.getPassword()));
		entry.setRoles(Arrays.asList("USER","ADMIN"));
		return repo.save(entry);
	}
	
	public Users saveUser(Users entry) {
		return repo.save(entry);
	}

	public List<Users> geatAll() {
		return repo.findAll();
	}

	public Optional<Users> getJournalById(ObjectId id) {
		Optional<Users> optional = repo.findById(id);
		if (optional.isPresent()) {
			optional.get();
			return optional;
		}
		return null;

	}

	public boolean deleteJournalById(ObjectId id) {
		repo.deleteById(id);
		return true;

	}

	public Users findByName(String userName) {
		return repo.findByUserName(userName);
	}

}
