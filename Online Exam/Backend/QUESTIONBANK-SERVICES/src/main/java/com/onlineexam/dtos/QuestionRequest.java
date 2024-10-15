package com.onlineexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest
{
    String mail;
    String category;
    Integer qid;
    String question;
    String opt1;
    String opt2;
    String opt3;
    String opt4;
    String ans;
    String score;
}