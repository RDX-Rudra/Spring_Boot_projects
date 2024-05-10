package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(MyController.myMethode());
		SpringApplication.run(NewApplication.class, args);
	}

}
