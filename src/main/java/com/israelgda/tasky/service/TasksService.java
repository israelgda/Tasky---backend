package com.israelgda.tasky.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.repository.TasksRepository;

@Service
public class TasksService {

	@Autowired
	private TasksRepository repository;
	
	public List<Tasks> findAll(){
		return repository.findAll();
	}
	
	public Tasks findById(Integer id){
		Optional<Tasks> task =  repository.findById(id);
		return task.orElse(null);
	}
}
