package com.onlineexam.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result
{
    String mail;
    Integer eid;
    List<Mark> marks;
}