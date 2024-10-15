package com.onlineexam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineexam.models.User;

public interface UserRepository extends MongoRepository<User,String>{}