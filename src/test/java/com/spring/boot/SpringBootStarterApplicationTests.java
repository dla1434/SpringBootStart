package com.spring.boot;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.model.SearchParam;
import com.spring.boot.service.ArgusService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
//@ActiveProfiles("local")
//@ActiveProfiles("dev")
@ActiveProfiles("prod")
public class SpringBootStarterApplicationTests {
	@Autowired
	private ArgusService argusService;

	@Test
	public void queryTest() {
		//Argus Service
		SearchParam searchParam = new SearchParam();
		searchParam.setIndex(Optional.of("gram-prod-2018.06.19"));
		searchParam.setType(Optional.of("gram_daemon"));
		searchParam.setMessage(Optional.of("ActiveJobs"));
		argusService.searchByQueryBuilder(searchParam);
	}
}
