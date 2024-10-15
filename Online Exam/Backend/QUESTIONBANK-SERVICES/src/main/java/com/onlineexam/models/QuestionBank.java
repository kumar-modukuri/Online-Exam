package com.onlineexam.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineexam.dtos.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "questionbanks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionBank 
{
    @Id
    String mail;
    List<Question> questions;
}