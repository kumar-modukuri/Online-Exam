package com.onlineexam.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineexam.models.ExamBank;

public interface ExamBankRepository extends MongoRepository<ExamBank,String>{}