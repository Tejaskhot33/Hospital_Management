package com.qsp.Hospital_Management.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Cause Can't be blank")
	@NotNull(message = "Cause Can't be null")
	private String cause;
	@Min(value=1)
	private double cost;
	@ManyToOne
	Person person;
	@OneToMany
	List<Branch> branches;
	
	
}
