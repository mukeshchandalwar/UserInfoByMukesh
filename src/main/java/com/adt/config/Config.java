package com.adt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.adt.listener.JobListener;
import com.adt.model.UserInfo;
import com.adt.processor.UserItemProcessor;

@Configuration
@EnableBatchProcessing
public class Config {
	@Autowired
	private JobBuilderFactory builderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobListener jobListener;
	@Autowired
	private UserItemProcessor itemProcessor;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean(name = "reader")
	public FlatFileItemReader<UserInfo> createReader(){
		return new FlatFileItemReaderBuilder<UserInfo>()
				.name("file-reader")
				.resource(new ClassPathResource("UserInfo.csv"))
				.delimited().delimiter(",")
				.names("userId","name","address","email")
				.targetType(UserInfo.class)
				.build();
	}
	@Bean
	public JpaItemWriter<UserInfo> createWriter() {
		return new JpaItemWriterBuilder<UserInfo>()
				.entityManagerFactory(entityManagerFactory)
				.build();
	}
	@Bean(name = "step")
	public Step createStep(){
		return stepBuilderFactory.get("step")
				.<UserInfo, UserInfo>chunk(2)
				.reader(createReader())
				.processor(itemProcessor)
				.writer(createWriter())
				.build();
	}
	@Bean(name = "job")
	public Job createJob() {
		return builderFactory.get("job")
				.listener(jobListener)
				.incrementer(new RunIdIncrementer())
				.start(createStep())
				.build();
	}
}
