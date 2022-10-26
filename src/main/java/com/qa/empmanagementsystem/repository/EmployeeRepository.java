package com.qa.empmanagementsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.empmanagementsystem.entity.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.department = :department")
	List<Employee> findByDepartment(String department);
	
	@Query("select e from Employee e where e.gender = :gender")
	List<Employee> findEmployeesByGender(char gender);

	@Query("select e from Employee e where e.gender = :gender  and e.department = :department")
	List<Employee> findEmployeesByGenderAndDepartment(char gender, String department);
	
	@Query("select e from Employee e where e.name = :name")
	List<Employee> findEmployeesByName(String name);

	
	
}
