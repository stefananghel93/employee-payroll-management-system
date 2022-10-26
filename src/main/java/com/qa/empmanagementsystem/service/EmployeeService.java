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
		
		
}
