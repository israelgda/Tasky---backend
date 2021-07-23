package com.israelgda.tasky.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.repository.TasksRepository;

@Service
public class DBService {

	@Autowired
	private TasksRepository repository;
	
	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Tasks t1 = new Tasks(null, "Projeto de Angular", "Estudar Angular 11 e Spring 2", sdf.parse("23/07/2021"),
				false);

		repository.saveAll(Arrays.asList(t1));
	}
}
