package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee e1);

	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee empdb);

	void deleteEmployeeById(int id);

}