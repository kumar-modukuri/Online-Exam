package com.onlineexam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineexam.models.QuestionBank;

public interface QuestionBankRepository extends MongoRepository<QuestionBank,String>{}