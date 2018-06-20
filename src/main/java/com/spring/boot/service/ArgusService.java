package com.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.model.Book;
import com.spring.boot.model.SearchParam;
import com.spring.boot.repository.EsClient;

import lombok.extern.slf4j.Slf4j;

public interface ArgusService {
	public void searchByQueryBuilder(SearchParam searchParam);
}