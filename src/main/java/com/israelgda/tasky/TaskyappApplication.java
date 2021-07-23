package com.israelgda.tasky;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskyappApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(TaskyappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
