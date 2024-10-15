package com.onlineexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.dtos.LoginDetails;
import com.onlineexam.dtos.UserRequest;
import com.onlineexam.dtos.UserResponse;
import com.onlineexam.services.UserServices;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserServices service;

    // GET BY MAIL

    @GetMapping("{mail}")
    public ResponseEntity<UserResponse> getByMail(@PathVariable("mail") String mail)
    {
        return service.getByMail(mail);
    }

    // UPDATE

    @PostMapping("update")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest request)
    {
        return service.update(request);
    }

    // DELETE

    @PostMapping("delete")
    public ResponseEntity<String> delete(@RequestBody LoginDetails details)
    {
        return service.delete(details);
    }
}