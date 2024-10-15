package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResultbankServicesApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ResultbankServicesApplication.class, args);
		System.out.println("\nRESULTBANK-SERVICES RUNNING ON PORT : 8086");
	}
}