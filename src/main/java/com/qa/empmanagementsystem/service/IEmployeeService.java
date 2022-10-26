package com.qa.empmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.repository.EmployeeRepository;

@Service
public class IEmployeeService implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	
	
	@Override
	public Employee signUp(Employee employee) throws EmployeeAlreadyExistsException {
		Optional<Employee> findByIdOptional = this.empRepository.findById(employee.getId());
		
		if(findByIdOptional.isPresent())
			throw new EmployeeAlreadyExistsException();
		
		return this.empRepository.save(employee);
	}

	@Override
	public Employee logIn() {
		// TODO Auto-generated method stub
		return null;
	}

}
