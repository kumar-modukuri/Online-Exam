package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExambankServicesApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ExambankServicesApplication.class, args);
		System.out.println("\nEXAMBANK-SERVICES RUNNING ON PORT : 8085");
	}
}