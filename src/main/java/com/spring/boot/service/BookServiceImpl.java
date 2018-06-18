package com.spring.boot.service;

import org.springframework.stereotype.Service;

import com.spring.boot.model.Book;
import com.spring.boot.repository.EsClient;

@Service
public class BookServiceImpl implements BookService {
	public void save(Book book) {
		EsClient esClient = new EsClient();
		esClient.save(book);
	}
	
	public Book findOne(String id) {
		EsClient esClient = new EsClient();
		return esClient.findById(id);
	}

	public void delete(Book book) {
		EsClient esClient = new EsClient();
		esClient.delete(book);
	}
}