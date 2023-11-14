package com.qsp.Hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can't be blank")
	@NotNull(message = "Name Can't be null")
	private String name;
	@NotBlank(message = "City Can't be blank")
	@NotNull(message = "City Can't be null")
	private String city;
	@NotBlank(message = "State Can't be blank")
	@NotNull(message = "State Can't be null")
	private String state;
	@Min(value = 111111)
	@Max(value = 999999)
	private int pincode;
}
