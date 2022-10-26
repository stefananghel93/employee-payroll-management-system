package com.qa.empmanagementsystem.controller;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeNotFoundException;
import com.qa.empmanagementsystem.service.EmployeeService;


@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	ResponseEntity<?> responseEntity;
	
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees(){
		try {
			List<Employee> empList = this.empService.getAllEmployees();
			responseEntity = new ResponseEntity<>(empList,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException{
		try {
			Employee employee = this.empService.getEmployeeById(id);
			responseEntity = new ResponseEntity<>(employee,HttpStatus.OK);
		} catch(EmployeeNotFoundException e) {
			throw e;
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return responseEntity;
		
	}
	
	@PutMapping("/employees")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException{
		try {
			Employee updatedEmployee = this.empService.updateEmployee(employee);			
			responseEntity = new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
		} catch(EmployeeNotFoundException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") @Min(value = 0,message = "id should be greater than 0")  int id) throws EmployeeNotFoundException{
		try {
			boolean status = this.empService.deleteEmployee(id);			
			if(status)
			responseEntity = new ResponseEntity<>("Employee deleted Successfuly !!",HttpStatus.OK);
		} catch(EmployeeNotFoundException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	
	@GetMapping("/employees/department/{department}")
	public ResponseEntity<?> findEmployeesByDepartment(@PathVariable("department") String department){
		try {
			List<Employee> empListByDepartment = this.empService.findEmployeesByDepartment(department);
			responseEntity = new ResponseEntity<>(empListByDepartment,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	@GetMapping("/employees/gender/{gender}")
	public ResponseEntity<?> findEmployeesByGender(@PathVariable("gender") char gender){
		try {
			List<Employee> empListByGender = this.empService.findEmployeesByGender(gender);
			responseEntity = new ResponseEntity<>(empListByGender,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	
	@GetMapping("/employees/gender/{gender}/department/{dept}")
	public ResponseEntity<?> findEmployeesByGenderAndDepartment(@PathVariable("gender") char gender,@PathVariable("dept") String department){
		try {
			List<Employee> empListByGenderAndDepartment = this.empService.findEmployeesByGenderAndDepartment(gender,department);
			responseEntity = new ResponseEntity<>(empListByGenderAndDepartment,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<?> findAllEmployeesByName(@PathVariable("name") String name){
		try {
			List<Employee> empListByName = this.empService.findEmployeesByName(name);
			responseEntity = new ResponseEntity<>(empListByName,HttpStatus.OK);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>("Internal error occured..Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}
	
}
