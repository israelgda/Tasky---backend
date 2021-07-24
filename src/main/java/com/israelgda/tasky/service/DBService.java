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

		Tasks t1 = new Tasks(null, "Projeto de Angular", "Estudar Angular 11 e Spring 2", sdf.parse("23/07/2021"), false);
		Tasks t2 = new Tasks(null, "Continuar o projeto", "Estudando Services e Resources", sdf.parse("22/07/2021"), false);
		Tasks t3 = new Tasks(null, "Teste de task", "Só testando", sdf.parse("22/07/2021"), true);
		Tasks t4 = new Tasks(null, "Teste 4 de Task", "Testando novamente uma task", sdf.parse("22/07/2021"), true);
		
		repository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
