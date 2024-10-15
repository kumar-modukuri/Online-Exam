package com.onlineexam.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineexam.dtos.QuestionResponse;

@FeignClient(name = "QUESTIONBANK-SERVICES", path = "/api/questionbank")
public interface QuestionBankInterface
{
    // GET ALL

    @GetMapping("{mail}")
    ResponseEntity<List<QuestionResponse>> getAll(@PathVariable("mail") String mail);
}