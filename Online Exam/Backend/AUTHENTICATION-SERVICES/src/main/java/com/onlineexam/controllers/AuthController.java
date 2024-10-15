package com.onlineexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.dtos.LoginDetails;
import com.onlineexam.dtos.UserRequest;
import com.onlineexam.dtos.UserResponse;
import com.onlineexam.services.AuthServices;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController
{
    @Autowired
    private AuthServices service;

    // SIGNUP

    @PostMapping("signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest request)
    {
        return service.signup(request);
    }

    // LOGIN

    @PostMapping("login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginDetails details)
    {
        return service.login(details);
    }
}