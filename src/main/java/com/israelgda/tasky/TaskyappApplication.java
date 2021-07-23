package com.israelgda.tasky;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.repository.TasksRepository;

@SpringBootApplication
public class TaskyappApplication implements CommandLineRunner{

	@Autowired
	private TasksRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskyappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Tasks t1 = new Tasks(null, "Projeto de Angular", "Estudar Angular 11 e Spring 2", sdf.parse("23/07/2021"), false);
		
		repository.saveAll(Arrays.asList(t1));
	}

}
