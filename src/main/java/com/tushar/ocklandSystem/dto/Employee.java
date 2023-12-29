package com.tushar.ocklandSystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@NotNull(message = "Name can not be empty")
	@Pattern(regexp = "^(?:[A-Z][a-z]*\\s?)+$", message = "*Provide a proper Name, First letter must be Uppercase")
	private String name;

	@NotNull(message = "Date Of Birth can not be empty")
	@NotBlank(message = "*Date Of Birth can not be blank")
	private String dateOfBirth;

	@NotNull(message = "Gender can not be empty")
	@Pattern(regexp = "^(?:male|Male|female|Female|other|Other)$", message = "*Gender must be Male/Female/Other")
	private String gender;

	@NotNull(message = "Address can not be Null")
	@NotBlank(message = "Address can not be blank")
	private String address;

	@NotNull(message = "City can not be Null")
	@Pattern(regexp = "^(?:[A-Z][a-z]*\\s?)+$", message = "*Provide a proper City name, First letter must be Uppercase")
	private String city;

	@NotNull(message = "State can not be Null")
	@Pattern(regexp = "^(?:[A-Z][a-z]*\\s?)+$", message = "*Provide a proper State name, First letter must be Uppercase")
	private String state;

	@Column(unique = true)
	@NotNull(message = "Login Id can not be null")
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9_]{4,16}$", message = "*1.Login Id start with an alphabet, 2.All other characters can be alphabets, numbers or an underscore, 3.Login Id must be between 5 to 15 characters")
	private String loginId;

	@Column(unique = true)
	@NotNull(message = "Password can not be Null")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,12}$", message = "*Password must contain at least one Uppercase and one Lowercase letter, at least one number, at least one special character and between 6-12 characters.")
	private String password;
}
