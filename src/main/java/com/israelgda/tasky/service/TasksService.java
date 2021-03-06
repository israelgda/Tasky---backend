package com.israelgda.tasky.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.israelgda.tasky.domain.Tasks;
import com.israelgda.tasky.repository.TasksRepository;
import com.israelgda.tasky.service.exceptions.ObjectNotFoundException;

@Service
public class TasksService {

	@Autowired
	private TasksRepository repository;
	
	/* Método para busar todos as tasks cadastradas e retornar em uma List<> */
	public List<Tasks> findAll(){
		return repository.findAll();
	}
	
	/* Método para encontrar uma task por ID */
	public Tasks findById(Integer id){
		Optional<Tasks> task =  repository.findById(id);
		return task.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	/* Método para encontrar todos as tasks em aberto e retornar em uma List<> */
	public List<Tasks> findAllOpen() {
		List<Tasks> listOpen = repository.findAllOpen();
		return listOpen;
	}
	
	/* Método para encontrar todos as tasks finalizadas e retornar em uma List<> */
	public List<Tasks> findAllClosed() {
		List<Tasks> listClosed = repository.findAllClosed();
		return listClosed;
	}
	
	/*Método CREATE para inserir uma Task no banco*/
	public Tasks create(Tasks task) {
		/*Setando ID null para evitar increment manual*/
		task.setId(null);
		return repository.save(task);
	}
	
	/*Método DELETE para apagar uma Task no banco*/
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
	}

	public Tasks update(Integer id, Tasks task) {
		try {
			Tasks novaTask= findById(id);
			novaTask.setTitulo(task.getTitulo());
			novaTask.setDescricao(task.getDescricao());
			novaTask.setDataFinal(task.getDataFinal());
			novaTask.setFinalizado(task.isFinalizado());
			return repository.save(novaTask);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException(id);
		}
	}
	
}
