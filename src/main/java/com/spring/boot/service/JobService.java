package com.spring.boot.service;

import java.util.Date;

import org.springframework.scheduling.quartz.QuartzJobBean;

public interface JobService {
	boolean scheduleCronJob(String jobName, Class<? extends QuartzJobBean> jobClass, Date date, String cronExpression);
}
