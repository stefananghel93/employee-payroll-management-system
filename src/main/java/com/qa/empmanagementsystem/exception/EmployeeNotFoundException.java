package com.qa.empmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Employee found with this id")
public class EmployeeNotFoundException extends Exception {

}
