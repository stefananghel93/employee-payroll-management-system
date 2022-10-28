# Employee Payroll Management System

The objective of this assignment is to create a employee payroll management system web page which displays the employees details within an organization with id, name, email, phone, age, salary, and department. The user can add, update, display, delete and search for employees by passing specific properties like id, name, department, gender. 


### Problem Statement

Create webservices using SpringBoot with the following mentioned components:
1.mySQL database, to store data about employees.
2.using different layers like entity, exception, repository, service, controller.
3.components to edit and display data from the database.


### Tech Stack 

This application is build using the following tech stack

1.Java SE 17
2.Maven 3.8.6
3.SpringBoot 2.7.5
4.MySQL 8.0.31 


### Steps

1. SignUp employees data in database.
2. Fetch the employees from db.json using fetch API at the API URL `http://localhost:8080/employees`
3. Get employees information by passing the employee id at the API URL `http://localhost:8080/employees/{id}`
4. Remove an employee from database by passing their employee id using a DELETE request at the API URL`http://localhost:8081/employees/{id}`
5. Find an employee in the database by passing the employee name at the API URL `http://localhost:8081/employees/name/{name}`
6. Find employees by their gender in the database by passing their gender at the API URL `http://localhost:8081/employees/gender/{gender}`
7. Find an employee in the database by passing the employee name at the API URL `http://localhost:8081/employees/name/{name}`

# End Points
```bash
http://localhost:8081/api/v1/signUp
```
```bash
http://localhost:8081/api/v1/employees
```
```bash
http://localhost:8081/api/v1/employees
```
```bash
http://localhost:8081/api/v1/employees/{id}
```


### Employee SignUp

![Image Not Found](/api-documentation-images/CREATE.png)

### Get all employees

![Image Not Found](/api-documentation-images/READ.png)

### Update employee details

![Image Not Found](/api-documentation-images/UPDATE.png)

### Delete employee 

![Image Not Found](/api-documentation-images/DELETE.png)
