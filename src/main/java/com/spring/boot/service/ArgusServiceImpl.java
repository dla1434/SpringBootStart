package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.model.SearchParam;
import com.spring.boot.repository.EsClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArgusServiceImpl implements ArgusService {
	@Autowired
	private EsClient esClient;
	
	public void searchByQueryBuilder(SearchParam searchParam){
		esClient.searchByQueryBuilder(searchParam);
	}
}