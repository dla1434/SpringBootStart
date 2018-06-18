package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.model.Book;
import com.spring.boot.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		log.info("Web Server Root Start");
		
		Book findOne = bookService.findOne("1001");
		log.info("findOne : {}", findOne);
		
		return "index";
	}
}
