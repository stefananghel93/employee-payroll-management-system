package com.qa.empmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "emp_details")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min =2, max=20, message = "Name must be between 2 and 20 charaters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "Invalid name, must contain only letters")
	private String name;
	
	@NotNull
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Invalid email")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^(6|7|8|9)\\d{9}$", message = "invalid mobile number")
	private String phone;
	
	
	@NotNull
	@Size(min = 2, max = 20, message = "name must be between 2 and 20 alphanumeric characters")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "Invalid username, must contain only alphanumeric")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
	private String password;
	
	
	private char gender;
	@Min(value = 16, message = "Age must be min 16")
	@Max(value = 70, message="Age must be less than 70")
	private int age;
	
	@NotNull
	@Min(0)	
	private double salary;
	
	@NotNull
	@Size(min = 2, max = 20, message = "Department must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z]*", message = "Invalid department, must contain only letters")
	private String department;

}
