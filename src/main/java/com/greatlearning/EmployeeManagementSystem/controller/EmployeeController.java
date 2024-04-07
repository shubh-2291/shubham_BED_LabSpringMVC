package com.greatlearning.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/listEmployees")
	public String listEmployees(Model model) {
		List<Employee> emplist = employeeService.getAllEmployees();
		model.addAttribute("employees", emplist);
		return "employees";
	}

	@GetMapping("/new")
	public String createEmployeeForm(Model model) {
		Employee e1 = new Employee();
		model.addAttribute("employee", e1);
		return "create_employee";
	}

	@PostMapping()
	public String saveEmployee(@ModelAttribute("employee") Employee e1) {
		employeeService.saveEmployee(e1);
		return "redirect:/employees/listEmployees";
	}

	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable int id, Model model) {
		Employee empdb = employeeService.getEmployeeById(id);
		model.addAttribute("employee", empdb);
		return "edit_employee";
	}

	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee newValues) {
		Employee empdb = employeeService.getEmployeeById(id);
		empdb.setFirstName(newValues.getFirstName());
		empdb.setLastName(newValues.getLastName());
		empdb.setEmail(newValues.getEmail());
		employeeService.updateEmployee(empdb);
		return "redirect:/employees/listEmployees";
	}

	@GetMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees/listEmployees";
	}
}
