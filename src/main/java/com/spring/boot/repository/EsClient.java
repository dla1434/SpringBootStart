package com.spring.boot.repository;

import java.time.LocalDateTime;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fatboyindustrial.gsonjavatime.LocalDateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.boot.model.Book;
import com.spring.boot.model.SearchParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Repository
@Component
public class EsClient{
	private static final String INDEX_NAME = "boot";
	private static final String TYPE_ITEMS = "book";
	
	public static final Gson  MAPPER =  new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter()).create();
	
	@Autowired
	private ElasticsearchOperations es;
	
	@Autowired
	private Client client;
	
	public void save(Book boook){
		Client client = es.getClient();
		String json = MAPPER.toJson(boook);
		IndexResponse response = client.prepareIndex(INDEX_NAME, TYPE_ITEMS, boook.getId())
			.setSource(json, XContentType.JSON).execute().actionGet();
		
		log.info("responseId - {}", response.getId());
	}
	
	public Book findById(String id){
		Client client = es.getClient();
		GetResponse response = client.prepareGet(INDEX_NAME, TYPE_ITEMS, id)
				.setFetchSource(true)
				.get();
		
		if(response.isExists()) {
			try {
				Book book = new Gson().fromJson(response.getSourceAsString(), Book.class);
				log.info("getBook - {}", book);
				
				return book;
			} catch (Exception e) {
				log.error("Book select Fail! - {}", id);
			}
		}
		
		return null;
	}
	
	public void delete(Book book){
		Client client = es.getClient();
		DeleteResponse response = client.prepareDelete(INDEX_NAME, TYPE_ITEMS, book.getId())
				.execute().actionGet();
		
		String id = response.getId();
		
		if (StringUtils.isEmpty(id)) {
			throw new RuntimeException("book is Wrong!! "+ id);
		}
		
		log.info("delete bookId - {}", id);
	}
	
	public void searchByQueryBuilder(SearchParam searchParam){
		log.info("EsClient.searchByQueryBuilder Start");
		
		SearchRequestBuilder searchBuilder = client.prepareSearch(searchParam.getIndex().get()).setTypes(searchParam.getType().get());
		
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//		queryBuilder = queryBuilder.must(QueryBuilders.wildcardQuery("message", String.format("*%s*", searchParam.getMessage().get())))
		queryBuilder = queryBuilder.must(QueryBuilders.wildcardQuery("message.keyword", String.format("*%s*", searchParam.getMessage().get())))
					.must(QueryBuilders.rangeQuery("timestamp").gte("2018-06-19 01:00:00,000").lte("2018-06-19 23:00:00,000"));
		
//		log.info("queryBuilder : {}", queryBuilder);
		
		searchBuilder.setQuery(queryBuilder);
		
		SearchResponse response = searchBuilder.execute().actionGet();
		
		log.info("searchBuilder : {}, resp size : {}", searchBuilder, response.getHits().getTotalHits());
		
		for (SearchHit hit : response.getHits().getHits()) {
			log.info("loop : {}", hit.getSourceAsString());
		}
	}
}
