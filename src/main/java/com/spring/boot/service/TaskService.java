package com.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.boot.model.Task;
import com.spring.boot.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	private final TaskRepository taskRepositry;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepositry = taskRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		for(Task task : taskRepositry.findAll()) {
			tasks.add(task);
		}
		
		return tasks;
	}
	
	public Task findTask(int id) {
		return taskRepositry.findById(id).get();
	}
	
	public void save(Task task) {
		taskRepositry.save(task);
	}
	
	public void delete(int id) {
		taskRepositry.deleteById(id);
	}
}
