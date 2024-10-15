package com.onlineexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.dtos.QuestionRequest;
import com.onlineexam.dtos.QuestionResponse;
import com.onlineexam.services.QuestionBankServices;

@RestController
@RequestMapping("/api/questionbank")
@CrossOrigin("*")
public class QuestionBankController
{
    @Autowired
    private QuestionBankServices service;

    // ADD QUESTION

    @PostMapping
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody QuestionRequest request)
    {
        return service.addQuestion(request);
    }

    // GET ALL

    @GetMapping("{mail}")
    public ResponseEntity<List<QuestionResponse>> getAll(@PathVariable("mail") String mail)
    {
        return service.getAll(mail);
    }

    // UPDATE

    // DELETE
}