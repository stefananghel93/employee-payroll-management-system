package com.qa.empmanagementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.empmanagementsystem.dto.EmployeeDto;
import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.exception.EmployeeNotFoundException;
import com.qa.empmanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
   @Autowired
	ModelMapper modelMapper;
	
	
	
	@Override
	public Employee signUp(Employee employee) throws EmployeeAlreadyExistsException {
		
		 Optional<Employee> findByIdOptional = this.empRepository.findById(employee.getId());
		 if(findByIdOptional.isPresent())
			 throw new EmployeeAlreadyExistsException();
		 else
			 return this.empRepository.save(employee);
	}

	@Override
	public List<EmployeeDto> getlogIn() {
		return this.empRepository.findAll().stream().map(this::mapToEmployeeDto).collect(Collectors.toList());
		
	}

	private EmployeeDto mapToEmployeeDto(Employee employee) {
		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return this.empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		
		Optional<Employee> findByIdOptional = this.empRepository.findById(id);
		 if(!findByIdOptional.isPresent())
			 throw new EmployeeNotFoundException();
		return findByIdOptional.get();
	
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> findByIdOptional = this.empRepository.findById(employee.getId());
		 if(!findByIdOptional.isPresent())
			 throw new EmployeeNotFoundException();
		 else
			 return this.empRepository.save(employee);
	}

	@Override
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
		boolean status = false;
		Optional<Employee> findByIdOptional = this.empRepository.findById(id);
		 if(!findByIdOptional.isPresent())
			 throw new EmployeeNotFoundException();
		 
		 this.empRepository.delete(findByIdOptional.get());
		 status = true;
		 
		 return status;
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String department) {
		
		return this.empRepository.findByDepartment(department);
	}

	@Override
	public List<Employee> findEmployeesByGender(char gender) {
		return this.empRepository.findEmployeesByGender(gender);
	}

	@Override
	public List<Employee> findEmployeesByGenderAndDepartment(char gender, String department) {
		return this.empRepository.findEmployeesByGenderAndDepartment(gender, department);
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		return this.empRepository.findEmployeesByName(name);
	}
		
		
}
