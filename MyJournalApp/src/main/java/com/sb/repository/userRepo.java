package com.sb.repository;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sb.entity.Users;

public interface userRepo extends MongoRepository<Users, ObjectId> {

	Users findByUserName(String userName);
}
