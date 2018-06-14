package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		log.info("Web Server Root Start");
		
		return "index";
	}
}
