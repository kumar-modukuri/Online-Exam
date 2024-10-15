package com.onlineexam.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamRequest
{
    String mail;
    Integer eid;
    String ename;
    List<Integer> qids;
    Integer time;
    Integer total;
}