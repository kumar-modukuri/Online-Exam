package com.onlineexam.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineexam.dtos.Exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "exambank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamBank
{
    @Id
    String mail;
    List<Exam> exams;
}