package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.model.Book;
import com.spring.boot.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
//		bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
//		bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

//		Book findOne = bookService.findOne("1001");
//		log.info("findOne : {}", findOne);
	}
}
