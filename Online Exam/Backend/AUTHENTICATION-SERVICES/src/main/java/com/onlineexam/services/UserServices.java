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
public class UserServices
{
    @Autowired
    private UserRepository repo;

    // GET BY MAIL

    public ResponseEntity<UserResponse> getByMail(String mail)
    {
        try
        {
            User user = repo.findById(mail).orElse(null);

            if (user != null)
            {
                return new ResponseEntity<>(new UserResponse(user.getMail(), user.getUsername(), user.getRole()),HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in getByMail : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE

    public ResponseEntity<UserResponse> update(UserRequest request)
    {
        try
        {
            User user = repo.findById(request.getMail()).orElse(null);

            if(user != null)
            {
                if(request.getPassword() != "")
                {
                    user.setPassword(request.getPassword());
                }
                if(request.getUsername() != "")
                {
                    user.setUsername(request.getUsername());
                }

                repo.save(user);

                return new ResponseEntity<>(new UserResponse(user.getMail(),user.getUsername(),user.getRole()), HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch(Exception e)
        {
            System.out.println("\nException in update : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE

    public ResponseEntity<String> delete(LoginDetails details)
    {
        try
        {
            User user = repo.findById(details.getMail()).orElse(null);

            if (user != null)
            {
                if(user.getPassword().equals(details.getPassword()))
                {
                    repo.delete(user);

                    return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
                }

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in delete : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}