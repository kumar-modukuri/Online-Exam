package com.onlineexam.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlineexam.dtos.Question;
import com.onlineexam.dtos.QuestionRequest;
import com.onlineexam.dtos.QuestionResponse;
import com.onlineexam.models.QuestionBank;
import com.onlineexam.repositories.QuestionBankRepository;

@Service
public class QuestionBankServices
{
    @Autowired
    private QuestionBankRepository repo;

    // ADD QUESTION

    public ResponseEntity<QuestionResponse> addQuestion(QuestionRequest request)
    {
        try
        {
            QuestionBank bank = repo.findById(request.getMail()).orElse(null);

            if(bank == null)
            {
                bank = new QuestionBank(request.getMail(), new ArrayList<>());
            }

            for(Question q : bank.getQuestions())
            {
                if(q.getQid().equals(request.getQid()))
                {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }

            Question question = new Question(
                request.getCategory(),
                request.getQid(),
                request.getQuestion(),
                request.getOpt1(),
                request.getOpt2(),
                request.getOpt3(),
                request.getOpt4(),
                request.getAns(),
                request.getScore()
            );
            
            bank.getQuestions().add(question);

            repo.save(bank);

            QuestionResponse response = new QuestionResponse(
                request.getCategory(),
                request.getQid(),
                request.getQuestion(),
                request.getOpt1(),
                request.getOpt2(),
                request.getOpt3(),
                request.getOpt4(),
                request.getAns(),
                request.getScore()
            );

            return new ResponseEntity<>(response,HttpStatus.OK);
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
            QuestionBank bank = repo.findById(mail).orElse(null);

            if(bank != null)
            {
                return new ResponseEntity<>(bank.getQuestions().stream().map(question -> {

                    return new QuestionResponse(
                        question.getCategory(),
                        question.getQid(),
                        question.getQuestion(),
                        question.getOpt1(),
                        question.getOpt2(),
                        question.getOpt3(),
                        question.getOpt4(),
                        question.getAns(),
                        question.getScore()
                    );
                    
                }).collect(Collectors.toList()), HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch(Exception e)
        {
            System.out.println("\nException in getAll : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // UPDATE

    // DELETE
}