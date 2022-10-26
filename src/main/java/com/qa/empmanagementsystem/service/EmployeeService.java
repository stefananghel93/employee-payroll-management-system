package com.qa.empmanagementsystem.service;

import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;

public interface EmployeeService {

	public Employee signUp(Employee employee) throws EmployeeAlreadyExistsException;
	public Employee logIn();
}
