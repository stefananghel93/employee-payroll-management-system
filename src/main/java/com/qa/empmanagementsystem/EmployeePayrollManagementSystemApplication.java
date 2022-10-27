package com.qa.empmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableWebMvc
public class EmployeePayrollManagementSystemApplication {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollManagementSystemApplication.class, args);
	}

	
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.qa.empmanagementsystem.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
}

