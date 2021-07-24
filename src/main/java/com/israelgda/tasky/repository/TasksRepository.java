package com.israelgda.tasky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.israelgda.tasky.domain.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	

}
