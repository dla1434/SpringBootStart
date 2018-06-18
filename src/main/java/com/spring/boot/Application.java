package com.spring.boot;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.spring.boot.model.Book;
import com.spring.boot.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private ElasticsearchOperations es;
	
	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		printElasticSearchInfo();

		bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
		bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
		bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

		//Elastic Search Query
		Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));
		// List<Book> books = bookService.findByTitle("Elasticsearch Basics");

		books.forEach(x -> log.info("book : {}", x));
	}
	
	 //useful for debug, print elastic search details
	private void printElasticSearchInfo() {
		log.info("--START : Print ElasticSearch Setting Info--");
		Client client = es.getClient();
		
		Map<String, String> asMap = client.settings().getAsMap();

		asMap.forEach((k, v) -> {
			log.info("{} + = + {}", k, v);
		});
		log.info("--END : Print ElasticSearch Setting Info--");
	}
}
