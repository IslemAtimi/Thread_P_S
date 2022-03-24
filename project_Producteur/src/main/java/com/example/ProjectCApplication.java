package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.configuration.Client;

@SpringBootApplication
public class ProjectCApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(ProjectCApplication.class, args);
		
		Client.lancer();
	}

}
