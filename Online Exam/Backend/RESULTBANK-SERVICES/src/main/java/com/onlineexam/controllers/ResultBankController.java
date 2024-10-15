package com.onlineexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.dtos.ResultRequest;
import com.onlineexam.services.ResultBankServices;

@RestController
@RequestMapping("/api/resultbank")
@CrossOrigin("*")
public class ResultBankController
{
    @Autowired
    private ResultBankServices service;

    // ADD RESULT

    @PostMapping
    public ResponseEntity<String> addResult(@RequestBody ResultRequest request)
    {
        return service.addResult(request);
    }
}