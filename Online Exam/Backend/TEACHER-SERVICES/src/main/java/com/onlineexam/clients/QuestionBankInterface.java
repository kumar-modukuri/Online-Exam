package com.onlineexam.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlineexam.dtos.QuestionRequest;
import com.onlineexam.dtos.QuestionResponse;

@FeignClient(name = "QUESTIONBANK-SERVICES", path = "/api/questionbank")
public interface QuestionBankInterface
{
    // ADD QUESTION

    @PostMapping
    ResponseEntity<QuestionResponse> addQuestion(@RequestBody QuestionRequest request);

    // GET ALL

    @GetMapping("{mail}")
    ResponseEntity<List<QuestionResponse>> getAll(@PathVariable("mail") String mail);

    // UPDATE

    // DELETE
}