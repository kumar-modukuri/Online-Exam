package com.onlineexam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.clients.UserInterface;
import com.onlineexam.dtos.LoginDetails;
import com.onlineexam.dtos.UserRequest;
import com.onlineexam.dtos.UserResponse;

import feign.FeignException;

@Service
public class UserServices 
{
    @Autowired
    private UserInterface client;

    // GET BY MAIL

    public ResponseEntity<UserResponse> getByMail(String mail)
    {
        try
        {
            return client.getByMail(mail);
        }
        catch (FeignException e)
        {
            if (e.status() == HttpStatus.NOT_FOUND.value())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            System.out.println("\nFeign Exception in getByMail : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
            return client.update(request);
        }
        catch (FeignException e)
        {
            if (e.status() == HttpStatus.NOT_FOUND.value())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            System.out.println("\nFeign Exception in update : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
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
            return client.delete(details);
        }
        catch(FeignException e)
        {
            if(e.status() == HttpStatus.NOT_FOUND.value())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            if(e.status() == HttpStatus.UNAUTHORIZED.value())
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            System.out.println("\nFeign Exception in delete : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        catch(Exception e)
        {
            System.out.println("\nException in delete : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}