package com.tushar.ocklandSystem.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.tushar.ocklandSystem.dto.Employee;
import com.tushar.ocklandSystem.repo.EmployeeRepository;

@Controller
public class RegisterController {

	/*
	 * The @Autowired annotation is used to automatically inject an instance of
	 * EmployeeRepository into the RegisterController, allowing the controller
	 * to interact with the data repository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	// Display the registration form
	@GetMapping("/register")
	public String registrtaionForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "/register";
	}

	// Handle the submission of the registration form
	@PostMapping("/register")
	public String saveEmployee(@Valid Employee employee, BindingResult result) {

		// Check for validation errors
		if (result.hasErrors()) {
			return "register";
		}

		// Check if the login ID is already exists
		if (employeeRepository.existsByLoginId(employee.getLoginId())) {
			result.rejectValue("loginId", "error.employee", "*Login ID already exists");
			return "register";
		}

		// Check if the password is already exists
		if (employeeRepository.existsByPassword(employee.getPassword())) {
			result.rejectValue("password", "error.employee", "*Password already exist");
			return "register";
		}

		// Save the employee to the repository
		employeeRepository.save(employee);

		// Redirect to the login page after successful registration
		return "redirect:/login";
	}
}
