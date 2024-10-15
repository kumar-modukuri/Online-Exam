package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionbankServicesApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(QuestionbankServicesApplication.class, args);
		System.out.println("\nQUESTIONBANK-SERVICES RUNNING ON PORT : 8084");
	}
}