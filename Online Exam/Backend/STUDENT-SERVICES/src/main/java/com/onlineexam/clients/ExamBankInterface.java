package com.onlineexam.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineexam.dtos.Exam;

@FeignClient(name = "EXAMBANK-SERVICES", path = "/api/exambank")
public interface ExamBankInterface
{
    // GET ALL

    @GetMapping("{mail}")
    ResponseEntity<List<Exam>> getAll(@PathVariable("mail") String mail);
}