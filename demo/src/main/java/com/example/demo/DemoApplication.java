package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.controller.*;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@Slf4j
@Log4j2
//@EnableCircuitBreaker

//@ComponentScan(basePackageClasses = StudentController.class)
public class DemoApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		//log.info("hello");
		log.info("test info log: ");
		
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	    return builder.sources(DemoApplication.class);
	  }


}
