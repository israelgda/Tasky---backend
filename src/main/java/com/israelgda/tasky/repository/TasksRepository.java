package com.israelgda.tasky.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.israelgda.tasky.domain.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

	@Query("SELECT obj FROM Tasks obj WHERE obj.finalizado = false ORDER BY obj.dataFinal")
	List<Tasks> findAllOpen();
	

}
