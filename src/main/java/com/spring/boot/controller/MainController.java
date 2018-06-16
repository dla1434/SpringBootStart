package com.spring.boot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.model.Task;
import com.spring.boot.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		log.info("Web Server Root Start");
		request.setAttribute("page", "fragments/main");
		
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request) {
		log.info("allTasks");
		
		List<Task> findAll = taskService.findAll();
		log.info("tasks allTasks : {}", findAll);
		
		return "index";
	}
	
	@GetMapping("/save-task")
	public String saveTask(HttpServletRequest request, @ModelAttribute Task task, BindingResult bindResult) {
		log.info("saveTask");
		
		task.setDateCreated(new Date());
		task.setName("jpaTest");
		taskService.save(task);
		
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(HttpServletRequest request, @RequestParam int id) {
		log.info("deleteTask");
		
		taskService.delete(id);
		
		return "index";
	}
}
