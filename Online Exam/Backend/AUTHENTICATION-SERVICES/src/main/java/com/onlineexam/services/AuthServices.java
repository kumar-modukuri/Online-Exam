package com.onlineexam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.dtos.LoginDetails;
import com.onlineexam.dtos.UserRequest;
import com.onlineexam.dtos.UserResponse;
import com.onlineexam.models.User;
import com.onlineexam.repositories.UserRepository;

@Service
public class AuthServices 
{
    @Autowired
    private UserRepository repo;

    // SIGNUP

    public ResponseEntity<UserResponse> signup(UserRequest request)
    {
        try 
        {
            User user = repo.findById(request.getMail()).orElse(null);

            if(user == null)
            {
                repo.save(new User(request.getMail(),request.getPassword(),request.getUsername(),request.getRole()));
                
                return new ResponseEntity<>(new UserResponse(request.getMail(),request.getUsername(),request.getRole()), HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        catch(Exception e)
        {
            System.out.println("\nException in signup : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // LOGIN

    public ResponseEntity<UserResponse> login(LoginDetails details)
    {
        try
        {
            User user = repo.findById(details.getMail()).orElse(null);

            if(user != null)
            {
                if(user.getPassword().equals(details.getPassword()))
                {
                    return new ResponseEntity<>(new UserResponse(user.getMail(),user.getUsername(),user.getRole()), HttpStatus.OK);
                }

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in login : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}