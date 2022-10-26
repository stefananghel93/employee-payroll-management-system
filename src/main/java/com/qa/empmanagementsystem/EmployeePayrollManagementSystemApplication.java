package com.qa.empmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.modelmapper.ModelMapper;

@SpringBootApplication
public class EmployeePayrollManagementSystemApplication {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollManagementSystemApplication.class, args);
	}

}
