package com.rohit.springbootdemo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootdemoApplication.class, args);
		
		/*
		 * String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
		 * Arrays.sort(beanDefinitionNames); for(String beanName: beanDefinitionNames) {
		 * System.out.println(beanName);
		 * 
		 * }
		 */
		 
		
	}
}
