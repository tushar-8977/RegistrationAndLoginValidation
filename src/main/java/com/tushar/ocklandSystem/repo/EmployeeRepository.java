package com.tushar.ocklandSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.ocklandSystem.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom query method to find an employee by login ID
	Employee findByLoginId(String loginId);

	// Check if an employee with the given login ID exists
	boolean existsByLoginId(String loginId);

	// Check if an employee with the given password exists
	boolean existsByPassword(String password);
}
