package com.spring.boot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String home(HttpServletRequest request, ModelMap modelMap) {
		log.info("Web Server Root Start");
		
		modelMap.addAttribute("page", "fragments/main");
		
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request, ModelMap modelMap) {
		log.info("allTasks");
		
		List<Task> findAll = taskService.findAll();
		log.info("tasks allTasks : {}", findAll);
		
		modelMap.addAttribute("page", "fragments/task/taskList");
		modelMap.addAttribute("tasks", findAll);
		
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request, ModelMap modelMap) {
		log.info("newTask");
		
		modelMap.addAttribute("page", "fragments/task/taskView");
		
		return "index";
	}
	
	
	@PostMapping("/save-task")
	public String saveTask(HttpServletRequest request, @ModelAttribute Task task, BindingResult bindResult, ModelMap modelMap) {
		log.info("saveTask");
		
		task.setDateCreated(new Date());
		taskService.save(task);
		
		modelMap.addAttribute("tasks", taskService.findAll());
		modelMap.addAttribute("page", "fragments/task/taskList");
		
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(HttpServletRequest request, ModelMap modelMap, @RequestParam int id) {
		log.info("newTask");
		
		modelMap.addAttribute("task", taskService.findTask(id));
		modelMap.addAttribute("page", "fragments/task/taskView");
		
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(HttpServletRequest request, ModelMap modelMap, @RequestParam int id) {
		log.info("deleteTask");
		
		taskService.delete(id);
		
		modelMap.addAttribute("tasks", taskService.findAll());
		modelMap.addAttribute("page", "fragments/task/taskList");
		
		return "index";
	}
}
