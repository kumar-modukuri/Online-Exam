package com.onlineexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.clients.ExamBankInterface;
import com.onlineexam.dtos.Exam;

import feign.FeignException;

@Service
public class ExamBankServices
{
    @Autowired
    private ExamBankInterface client;
    
    // GET ALL

    public ResponseEntity<List<Exam>> getAll(String mail)
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
}