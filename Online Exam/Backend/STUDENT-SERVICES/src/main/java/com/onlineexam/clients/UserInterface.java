package com.onlineexam.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlineexam.dtos.LoginDetails;
import com.onlineexam.dtos.UserRequest;
import com.onlineexam.dtos.UserResponse;

@FeignClient(name = "AUTHENTICATION-SERVICES", path = "/api/users")
public interface UserInterface
{
    // GET BY MAIL

    @GetMapping("{mail}")
    ResponseEntity<UserResponse> getByMail(@PathVariable("mail") String mail);

    // UPDATE

    @PostMapping("update")
    ResponseEntity<UserResponse> update(@RequestBody UserRequest request);

    // DELETE
    
    @PostMapping("delete")
    ResponseEntity<String> delete(@RequestBody LoginDetails details);
}