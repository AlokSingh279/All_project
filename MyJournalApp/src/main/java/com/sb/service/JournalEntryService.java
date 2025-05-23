package com.sb.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sb.entity.JournalEntry;
import com.sb.entity.Users;
import com.sb.repository.JournalEntryRepo;
import com.sb.repository.userRepo;

@Component
public class JournalEntryService {

	@Autowired
	private JournalEntryRepo repo;

	@Autowired
	private userService userservice;

	@Transactional
	public JournalEntry createJournal(JournalEntry entry, String name) {

		try {
			Users users = userservice.findByName(name);
			entry.setDate(LocalDateTime.now());
			JournalEntry saved = repo.save(entry);
			users.getList().add(saved);
			// users.setUserName(null);//agar username ki field ko non null kar de toh yeh
			// transaction kam karega
			userservice.saveUser(users);
			return saved;
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("the data you enterd is not saved successfully" + e);
		}

	}

	public JournalEntry createJournal(JournalEntry entry) {
		JournalEntry saved = repo.save(entry);
		return saved;

	}

	public List<JournalEntry> geatAll() {

		return repo.findAll();
	}

	public Optional<JournalEntry> getJournalById(ObjectId id) {

		Optional<JournalEntry> optional = repo.findById(id);
		if (optional.isPresent()) {
			optional.get();
			return optional;
		}
		return null;

	}

	public boolean deleteJournalById(ObjectId id, String name) {

		Users users = userservice.findByName(name);
		boolean val = users.getList().removeIf(x -> x.getId().equals(id));
		if (val) {
			userservice.saveUser(users);
			repo.deleteById(id);
		}
		{
			return false;

		}
	}

	public JournalEntry updateJournalBy(ObjectId id, JournalEntry newentry) {

		JournalEntry old = getJournalById(id).get();

		if (old != null) {
			old.setName(newentry.getName());
			old.setContent(newentry.getContent());
			return old;
		}
		return null;

	}
}
