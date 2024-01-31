package com.jallenllc.mongodbspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbSpringDemoApplication.class, args);
	}
}
