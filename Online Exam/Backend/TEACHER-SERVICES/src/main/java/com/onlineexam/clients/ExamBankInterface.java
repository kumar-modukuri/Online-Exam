package com.onlineexam.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlineexam.dtos.Exam;
import com.onlineexam.dtos.ExamRequest;

@FeignClient(name = "EXAMBANK-SERVICES", path = "/api/exambank")
public interface ExamBankInterface
{
    // ADD EXAM

    @PostMapping
    ResponseEntity<Exam> addExam(@RequestBody ExamRequest request);

    // GET ALL

    @GetMapping("{mail}")
    ResponseEntity<List<Exam>> getAll(@PathVariable("mail") String mail);

    // UPDATE

    // DELETE
}