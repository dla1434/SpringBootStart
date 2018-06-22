package com.spring.boot.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTimeZone {
	@Test
	public void test() {
		SimpleDateFormat simpleDateFormat = null;
		Date myDate;
		String dateStr;
		
		try 
		{
			//Korea Time --> UTC Time
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			myDate = simpleDateFormat.parse("2018-06-19 03:16:51");
			System.out.println(myDate);
			
			System.out.println("-----------------------------------------------------------------------------------------");
		
			//UTC Time --> Korea Time 
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
			myDate = simpleDateFormat.parse("2018-06-19T03:16:51.865Z");
			System.out.println(myDate);
			
			System.out.println("-----------------------------------------------------------------------------------------");
			
			//Korea Time --> UTC Time : Add Format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			String koreaTimeStr = LocalDateTime.now().format(formatter);
			String utcTimeStr = LocalDateTime.now(Clock.systemUTC()).format(formatter);
			log.info("KoreaTime : {} ---> UTC Time : {}", koreaTimeStr, utcTimeStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
