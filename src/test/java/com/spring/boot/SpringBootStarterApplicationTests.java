package com.spring.boot;

import java.util.Optional;

import org.junit.Ignore;
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
//	@Ignore("this method isn’t working yet")
	public void gramQueryTest() {
		//Argus Service
		SearchParam searchParam = new SearchParam();
		searchParam.setIndex(Optional.of("gram-prod-2018.06.22"));
		searchParam.setType(Optional.of("gram_daemon"));
		searchParam.setMessage(Optional.of("ActiveJobs"));
		argusService.searchByQueryBuilder(searchParam);
	}
	
	@Test
	@Ignore
	public void letsQueryTest() {
		//Argus Service
		SearchParam searchParam = new SearchParam();
		searchParam.setIndex(Optional.of("lets-2018.06.21"));
		searchParam.setType(Optional.of("result_summary"));
		searchParam.setMessage(Optional.of("108350"));
		argusService.searchByQueryBuilder(searchParam);
	}
}
