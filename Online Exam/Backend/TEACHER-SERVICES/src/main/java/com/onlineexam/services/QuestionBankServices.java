package com.onlineexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.clients.QuestionBankInterface;
import com.onlineexam.dtos.QuestionRequest;
import com.onlineexam.dtos.QuestionResponse;

import feign.FeignException;

@Service
public class QuestionBankServices
{
    @Autowired
    private QuestionBankInterface client;

    // ADD QUESTION

    public ResponseEntity<QuestionResponse> addQuestion(QuestionRequest request)
    {
        try
        {
            return client.addQuestion(request);
        }
        catch (FeignException e)
        {
            if (e.status() == HttpStatus.CONFLICT.value())
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            System.out.println("\nFeign Exception in addQuestion : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in addQuestion : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // GET ALL

    public ResponseEntity<List<QuestionResponse>> getAll(String mail)
    {
        try
        {
            return client.getAll(mail);
        }
        catch (FeignException e)
        {
            if (e.status() == HttpStatus.NOT_FOUND.value())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            System.out.println("\nFeign Exception in getAll : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in getAll : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // UPDATE

    // DELETE
}