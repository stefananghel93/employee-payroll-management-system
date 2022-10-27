package com.qa.empmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.qa.empmanagementsystem.entity.Employee;
import com.qa.empmanagementsystem.exception.EmployeeAlreadyExistsException;
import com.qa.empmanagementsystem.exception.EmployeeNotFoundException;
import com.qa.empmanagementsystem.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository empRepository;
	
	@Autowired
	@InjectMocks
	private EmployeeService empService;
	
	Employee emp1;
	Employee emp2;
	Employee emp3;
	
	List<Employee> empList;
	
	@BeforeEach
	public void setUp() {
		/*
		 * Create the necessary instances
		 * Create dummy data
		 */
		emp1 = new Employee(1,"emp1","emp1@gmail.com","7452343267","employee1","Password1@",'M',25,1111.1,"devops");
		emp2 = new Employee(2,"emp2","emp2@gmail.com","6564564534","employee2","Password2@",'F',22,2222.2,"devops");
		emp3 = new Employee(3,"emp3","emp3@gmail.com","6564564523","employee3","Password3@",'F',25,3333.3,"development");
		empList = Arrays.asList(emp1,emp2,emp3);
	}
	
	@AfterEach
	public void tearDown() {
		emp1 = emp2 = emp3 =null;
		empRepository.deleteAll();
		empList = null;
		
	}
	
	@Test
	@DisplayName("save-employee-test")
	
	public void given_Employee_To_Save_Should_Return_The_Saved_Employee() throws EmployeeAlreadyExistsException {
		when(empRepository.findById(any())).thenReturn(Optional.empty());
		when(empRepository.save(any())).thenReturn(emp3);
		Employee savedEmployee = empService.signUp(emp3);
		assertNotNull(savedEmployee);
		assertEquals(3,savedEmployee.getId());
		
	}
	
	@Test
	@DisplayName("save-employee-throws-exception-test")
	
	public void given_Existing_Employee_To_Save_Method_Should_Throw_Exception() throws EmployeeAlreadyExistsException {
		when(empRepository.findById(any())).thenReturn(Optional.of(emp1));
		
		assertThrows(EmployeeAlreadyExistsException.class,()-> empService.signUp(emp1));
	}
	
}
