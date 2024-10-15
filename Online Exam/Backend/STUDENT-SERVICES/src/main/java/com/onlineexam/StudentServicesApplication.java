package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentServicesApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(StudentServicesApplication.class, args);
		System.out.println("\nSTUDENT-SERVICES RUNNING ON PORT : 8082");
	}
}