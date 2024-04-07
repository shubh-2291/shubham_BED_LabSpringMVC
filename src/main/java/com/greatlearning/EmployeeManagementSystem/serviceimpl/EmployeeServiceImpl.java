package com.greatlearning.EmployeeManagementSystem.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee e1) {
		return employeeRepo.save(e1);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee empdb) {
		return employeeRepo.save(empdb);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}

}
