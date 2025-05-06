package com.dashflow.ProjetoSaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dashflow"})
@EnableMongoRepositories(basePackages = {"com.dashflow.API.Repositories"})
public class ProjetoSaudeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSaudeApplication.class, args);
	}
}
