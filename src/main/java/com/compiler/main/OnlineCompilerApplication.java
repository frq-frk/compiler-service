package com.compiler.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class OnlineCompilerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCompilerApplication.class, args);
	}
}