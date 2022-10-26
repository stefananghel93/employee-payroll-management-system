package com.qa.empmanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.empmanagementsystem.dto.EmployeeDto;
import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.service.EmployeeService;


@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
	
	@Autowired
	EmployeeService empService;
	
	ResponseEntity<?> responseEntity;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		try {
		Employee newEmployee = this.empService.signUp(employee);
		responseEntity = new ResponseEntity<>(employee,HttpStatus.CREATED);
		}catch(EmployeeAlreadyExistsException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Internal issue occured, Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
		
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<?> getLogIn(){
		try {
			List<EmployeeDto> empDtoList = this.empService.getlogIn();
			responseEntity = new ResponseEntity<>(empDtoList,HttpStatus.OK);
			
		}catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal issue occured, Please try agian",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
		
	}

}
