package com.qa.empmanagementsystem.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.empmanagementsystem.entity.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
