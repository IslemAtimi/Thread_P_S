package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.configuration.server;

@SpringBootApplication
public class ProjectCsApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(ProjectCsApplication.class, args);
		
		server server =new server();
		server.lancer();
	}

}
