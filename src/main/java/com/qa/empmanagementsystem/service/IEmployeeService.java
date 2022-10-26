package com.qa.empmanagementsystem.service;

import java.util.List;

import com.qa.empmanagementsystem.dto.EmployeeDto;
import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;

public interface IEmployeeService {

	public Employee signUp(Employee employee) throws EmployeeAlreadyExistsException;
	public List<EmployeeDto> getlogIn();
	
	
	
}
