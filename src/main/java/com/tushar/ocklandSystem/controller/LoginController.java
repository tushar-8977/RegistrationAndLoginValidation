package com.tushar.ocklandSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tushar.ocklandSystem.dto.Employee;
import com.tushar.ocklandSystem.repo.EmployeeRepository;

@Controller
public class LoginController {

	/*
	 * The @Autowired annotation is used to automatically inject an instance of
	 * EmployeeRepository into the LoginController, allowing the controller
	 * to interact with the data repository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	// Display the Login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// Handle the submission of login form
	@PostMapping("/login")
	public String employeeLogin(@RequestParam String loginId, @RequestParam String password, Model model) {

		// Check if the username or password is empty
		if (loginId.isEmpty() || password.isEmpty()) {
			model.addAttribute("error", "*Username and password are required.");
			return "login";
		}

		// Attempt to find the employee with the given login ID
		Employee employee = employeeRepository.findByLoginId(loginId);

		// Check if the employee exists and if the password matches
		if (employee == null || !employee.getPassword().equals(password)) {
			model.addAttribute("error", "*Invalid username or password");
			return "login";
		}
		// Redirect to the employee list page after successful login
		return "redirect:/employees";
	}
}
