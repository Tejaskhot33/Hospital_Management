package com.qsp.Hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotBlank(message = "Name Can't be blank")
	@NotNull(message = "Name Can't be null")
	String name;
	@Min(value = 6000000000l)
	@Max(value= 9999999999l)
	private long phone;
	@NotBlank(message = "Gmail Can't be blank")
	@NotNull(message = "Gmail Can't be null")
	@Email(regexp = "[a-z0-9_+$]+@[a-z0-9]+\\.[a-z]{2,3}",message="invalid Email")
	private String email;
	private String address;
	
}
