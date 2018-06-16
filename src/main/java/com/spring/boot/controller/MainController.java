package com.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.service.CodeService;
import com.spring.boot.vo.CodeVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@Autowired
	CodeService codeService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		log.info("Web Server Root Start");
		
		request.setAttribute("page", "fragments/main");
		
		return "index";
	}
	
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		log.info("list");
		
		CodeVO vo = new CodeVO();
		vo.setCdDo("123");
		vo.setCdUp("0000");
		vo.setCdDn("1000");
		vo.setCdKor("kor");
		vo.setCdEng("eng");
		vo.setCdDesc("desc");
		vo.setUseYn("y");
		vo.setCreId("id");
		
		log.info("select : {}", codeService.selectCodeList(vo));
		
		return "index";
	}
	
	@GetMapping("/save")
	public String save(HttpServletRequest request) {
		log.info("save");
		
		CodeVO vo = new CodeVO();
		vo.setCdDo("123");
		vo.setCdUp("0000");
		vo.setCdDn("1000");
		vo.setCdKor("kor");
		vo.setCdEng("eng");
		vo.setCdDesc("desc");
		vo.setUseYn("y");
		vo.setCreId("id");
		
		log.info("insert : {}", codeService.insertCode(vo));
		
		return "index";
	}
	
	@GetMapping("/update")
	public String update(HttpServletRequest request) {
		log.info("update");
		
		CodeVO vo = new CodeVO();
		vo.setCdDo("123");
		vo.setCdUp("0000");
		vo.setCdDn("1000");
		vo.setModId("id");
		
		log.info("update : {}", codeService.updateCode(vo));
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		log.info("delete");
		
		CodeVO vo = new CodeVO();
		vo.setCdDo("123");
		
		log.info("delete : {}", codeService.deleteCode(vo));
		
		return "index";
	}
}
