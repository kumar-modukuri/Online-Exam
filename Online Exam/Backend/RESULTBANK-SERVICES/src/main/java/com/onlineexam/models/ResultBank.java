package com.onlineexam.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineexam.dtos.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "resultbanks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBank 
{
    @Id
    String mail;
    List<Result> results;
}