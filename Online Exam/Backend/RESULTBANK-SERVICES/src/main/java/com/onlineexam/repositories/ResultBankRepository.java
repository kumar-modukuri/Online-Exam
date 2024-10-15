package com.onlineexam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineexam.models.ResultBank;

public interface ResultBankRepository extends MongoRepository<ResultBank,String>{}