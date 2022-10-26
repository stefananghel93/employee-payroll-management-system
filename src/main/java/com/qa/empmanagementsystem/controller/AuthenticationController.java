package com.qa.empmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.service.IEmployeeService;

@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
	
	@Autowired
	IEmployeeService emService;
	
	ResponseEntity<?> responseEntity;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		try {
		Employee newEmployee = this.emService.signUp(employee);
		responseEntity = new ResponseEntity<>(employee,HttpStatus.CREATED);
		}catch(EmployeeAlreadyExistsException e) {
			throw e;
		}catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal issue occured, Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
		
	}

}
