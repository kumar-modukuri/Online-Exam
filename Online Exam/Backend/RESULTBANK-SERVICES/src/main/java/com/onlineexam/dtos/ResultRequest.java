package com.onlineexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultRequest
{
    String smail;
    String tmail;
    Integer eid;
    Integer qid;
    String ans;
    String score;
}