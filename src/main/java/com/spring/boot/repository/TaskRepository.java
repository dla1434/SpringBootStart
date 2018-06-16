package com.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
