package com.israelgda.tasky.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.service.TasksService;

@RestController
@RequestMapping(value = "/tasks")
public class TasksResource {
	
	@Autowired
	private TasksService service;
	
	/* Endpoint para listar todas as tasks */
	@GetMapping
	public ResponseEntity<List<Tasks>> findAll(){
		List<Tasks> tasks = new ArrayList<>();
		tasks = service.findAll();
		return ResponseEntity.ok().body(tasks);
	}
	
	/* Endpoint para buscar uma task por Id */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tasks> findById(@PathVariable Integer id){
		Tasks task = service.findById(id);
		return ResponseEntity.ok().body(task);
	}
	
	/* Endpoint para listar todas as tasks em aberto */
	@GetMapping(value = "/open")
	public ResponseEntity<List<Tasks>> listAllOpen(){
		List<Tasks> listOpen = service.findAllOpen();
		return ResponseEntity.ok().body(listOpen);
	}
	
	/* Endpoint para listar todas as tasks finalizadas */
	@GetMapping(value = "/closed")
	public ResponseEntity<List<Tasks>> listAllClosed(){
		List<Tasks> listClosed = service.findAllClosed();
		return ResponseEntity.ok().body(listClosed);
	}
	
	/*Endpoint para o CREATE*/
	@PostMapping
	public ResponseEntity<Tasks> create(@RequestBody Tasks task){
		task = service.create(task);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).body(task);
	}

	/*Endpoint para o DELETE*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/* Endpoint para UPDATE */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tasks> update(@PathVariable Integer id, @RequestBody Tasks task){
		Tasks novaTask = service.update(id, task);
		return ResponseEntity.ok().body(novaTask);
		
	}
}
