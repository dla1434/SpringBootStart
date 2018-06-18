package com.spring.boot.service;

import com.spring.boot.model.Book;

public interface BookService {
	void save(Book book);

	void delete(Book book);

	Book findOne(String id);
}