package com.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.configuration.Client2;

@SpringBootApplication
public class ProjectC2Application {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//SpringApplication.run(ProjectC2Application.class, args);
		
		Client2.lancer();
	}

}
