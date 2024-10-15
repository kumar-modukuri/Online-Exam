package com.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigServerApplication.class, args);
		System.out.println("\nCONFIG-SERVER RUNNING ON PORT : 8888");
	}
}