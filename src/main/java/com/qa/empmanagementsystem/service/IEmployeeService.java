package com.qa.empmanagementsystem.service;

import java.util.List;

import com.qa.empmanagementsystem.dto.EmployeeDto;
import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.exception.EmployeeNotFoundException;


public interface IEmployeeService {

	public Employee signUp(Employee employee) throws EmployeeAlreadyExistsException;
	public List<EmployeeDto> getlogIn();
	
	
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException;
	public List<Employee> findEmployeesByDepartment(String department);
	public List<Employee> findEmployeesByGender(char gender);
    public List<Employee> findEmployeesByGenderAndDepartment(char gender, String department);
    public List<Employee> findEmployeesByName(String name);
    
    
}
