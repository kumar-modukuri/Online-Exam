package com.onlineexam.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.clients.QuestionBankInterface;
import com.onlineexam.dtos.Mark;
import com.onlineexam.dtos.QuestionResponse;
import com.onlineexam.dtos.Result;
import com.onlineexam.dtos.ResultRequest;
import com.onlineexam.models.ResultBank;
import com.onlineexam.repositories.ResultBankRepository;

import feign.FeignException;

@Service
public class ResultBankServices
{
    @Autowired
    private ResultBankRepository repo;

    @Autowired
    private QuestionBankInterface client;

    // ADD RESULT

    public ResponseEntity<String> addResult(ResultRequest request)
    {
        try
        {
            ResultBank bank = repo.findById(request.getSmail()).orElse(null);

            if (bank == null)
            {
                bank = new ResultBank(request.getSmail(), new ArrayList<>());
            }

            for (Result r : bank.getResults())
            {
                if (r.getEid().equals(request.getEid()))
                {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }

            List<Mark> marks = new ArrayList<>();

            List<QuestionResponse> responses = client.getAll(request.getTmail()).getBody();

            if (responses != null)
            {
                for (QuestionResponse response : responses)
                {
                    if (response.getQid().equals(request.getQid()) && response.getAns().equals(request.getAns()))
                    {
                        marks.add(new Mark(request.getQid(), 1));
                    }
                    if (response.getQid().equals(request.getQid()) && !response.getAns().equals(request.getAns()))
                    {
                        marks.add(new Mark(request.getQid(), 0));
                    }
                }

                Result result = new Result(request.getTmail(),request.getEid(), marks);

                bank.getResults().add(result);

                repo.save(bank);
            }

            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        catch (FeignException e)
        {
            if (e.status() == HttpStatus.NOT_FOUND.value())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            System.out.println("\nFeign Exception in addResult : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        catch (Exception e)
        {
            System.out.println("\nException in addResult : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}