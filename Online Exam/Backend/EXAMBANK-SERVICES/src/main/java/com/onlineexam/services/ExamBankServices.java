package com.onlineexam.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.dtos.Exam;
import com.onlineexam.dtos.ExamRequest;
import com.onlineexam.models.ExamBank;
import com.onlineexam.repositories.ExamBankRepository;

@Service
public class ExamBankServices
{
    @Autowired
    private ExamBankRepository repo;

    // ADD EXAM

    public ResponseEntity<Exam> addExam(ExamRequest request)
    {
        try
        {
            ExamBank bank = repo.findById(request.getMail()).orElse(null);

            if (bank == null)
            {
                bank = new ExamBank(request.getMail(), new ArrayList<>());
            }

            for (Exam e : bank.getExams())
            {
                if (e.getEid().equals(request.getEid()))
                {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }

            Exam exam = new Exam(
                request.getEid(),
                request.getEname(),
                request.getQids(),
                request.getTime(),
                request.getTotal()
            );

            bank.getExams().add(exam);

            repo.save(bank);

            return new ResponseEntity<>(exam, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println("\nException in addExam : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // GET ALL

    public ResponseEntity<List<Exam>> getAll(String mail)
    {
        try
        {
            ExamBank bank = repo.findById(mail).orElse(null);

            if(bank != null)
            {
                return new ResponseEntity<>(bank.getExams(), HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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