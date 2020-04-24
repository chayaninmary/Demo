package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomersApplication.class, args);
		//Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/customers", "postgres", "root").load();
		//flyway.migrate(); //Migratrion 
	}

}
