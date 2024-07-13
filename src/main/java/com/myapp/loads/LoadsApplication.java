package com.myapp.loads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class LoadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadsApplication.class, args);
	}

}
