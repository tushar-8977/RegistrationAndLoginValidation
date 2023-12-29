package com.tushar.ocklandSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tushar.ocklandSystem.dto.Employee;
import com.tushar.ocklandSystem.repo.EmployeeRepository;

@Controller
public class EmployeeListController {

	/*
	 * The @Autowired annotation is used to automatically inject an instance of
	 * EmployeeRepository into the EmployeeListController, allowing the controller
	 * to interact with the data repository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	// Display the list of all employees
	@GetMapping("/employees")
	public String findAllEmployees(Model model) {

		// Retrieve the list of all employees from the repository
		List<Employee> employees = employeeRepository.findAll();

		// Add the list of employees to the model for rendering in the view
		model.addAttribute("employees", employees);

		// Return the name of the view to be rendered (employees.html)
		return "employees";
	}
}
