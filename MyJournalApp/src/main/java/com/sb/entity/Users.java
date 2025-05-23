package com.sb.entity;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {

    @Id
	private ObjectId id;
	
	@Indexed(unique = true)
	private String userName;
	private String password;
	
	@DBRef
	private List<JournalEntry> list=new ArrayList<>();
	
	private List<String> roles;
	
	

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<JournalEntry> getList() {
		return list;
	}

	public void setList(List<JournalEntry> list) {
		this.list = list;
	}
	
	
	
	
	
	
}
