package com.adt.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.adt.service.UserInfoService;

public class UserInfoRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	@Autowired
	private UserInfoService infoService;
	@Override
	public void run(String... args) throws Exception {
		JobParameters parameters=new JobParametersBuilder().addDate("sysdate",new Date())
										.toJobParameters();

		JobExecution execution=jobLauncher.run(job,parameters);
		infoService.getAllUserEmail();
		
	}

}
