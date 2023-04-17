package com.adt.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component
public class JobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getStatus());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getStatus());

	}

}
