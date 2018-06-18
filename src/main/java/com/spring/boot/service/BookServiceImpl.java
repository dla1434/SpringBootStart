package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.boot.model.Book;
import com.spring.boot.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void delete(Book book) {
		bookRepository.delete(book);
	}

	public Book findOne(String id) {
		//you can use on spring 1.5.x, Deplecated from Spring 2.0.x
//		return bookRepository.findOne(id);
		return bookRepository.findById(id).get();
	}

	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
		return bookRepository.findByAuthor(author, pageRequest);
	}

	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public List<Book> findByDetail(String detail) {
		return bookRepository.findByDetail(detail);
	}
}