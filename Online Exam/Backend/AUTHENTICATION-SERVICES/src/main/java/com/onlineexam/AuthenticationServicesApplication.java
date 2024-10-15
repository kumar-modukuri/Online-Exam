package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationServicesApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(AuthenticationServicesApplication.class, args);
		System.out.println("\nAUTHENTICATION-SERVICES RUNNING ON PORT : 8081");
	}
}