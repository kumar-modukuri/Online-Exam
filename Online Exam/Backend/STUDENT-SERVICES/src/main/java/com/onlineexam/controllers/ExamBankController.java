package com.onlineexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.dtos.Exam;
import com.onlineexam.services.ExamBankServices;

@RestController
@RequestMapping("/api/students/exambank")
@CrossOrigin("*")
public class ExamBankController
{
    @Autowired
    private ExamBankServices service;

    // GET ALL

    @GetMapping("{mail}")
    public ResponseEntity<List<Exam>> getAll(@PathVariable("mail") String mail)
    {
        return service.getAll(mail);
    }
}