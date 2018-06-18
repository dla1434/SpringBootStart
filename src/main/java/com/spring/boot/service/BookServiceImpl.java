package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.model.Book;
import com.spring.boot.repository.EsClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private EsClient esClient;
	
	public void save(Book book) {
		esClient.save(book);
	}
	
	public Book findOne(String id) {
		Book book = esClient.findById(id);
		
		log.info("book findById : {}", book);
		
		return book;
	}

	public void delete(Book book) {
		esClient.delete(book);
	}
}