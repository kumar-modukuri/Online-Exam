package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TeacherServicesApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(TeacherServicesApplication.class, args);
		System.out.println("\nTEACHER-SERVICES RUNNING ON PORT : 8083");
	}
}