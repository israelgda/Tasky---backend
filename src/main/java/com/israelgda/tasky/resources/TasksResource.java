package com.israelgda.tasky.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.service.TasksService;

@RestController
@RequestMapping(value = "/tasks")
public class TasksResource {
	
	@Autowired
	private TasksService service;
	
	@GetMapping
	public ResponseEntity<List<Tasks>> findAll(){
		List<Tasks> tasks = new ArrayList<>();
		tasks = service.findAll();
		return ResponseEntity.ok().body(tasks);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tasks> findById(@PathVariable Integer id){
		Tasks task = service.findById(id);
		return ResponseEntity.ok().body(task);
	}
	
	@GetMapping(value = "/tasks/open")
	public ResponseEntity<List<Tasks>> listAllOpen(){
		List<Tasks> listOpen = service.findAllOpen();
		return ResponseEntity.ok().body(listOpen);
	}
	

}
