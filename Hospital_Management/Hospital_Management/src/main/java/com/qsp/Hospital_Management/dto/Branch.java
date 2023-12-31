package com.qsp.Hospital_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can't be blank")
	@NotNull(message = "Name Can't be null")
	private String name;
	@NotBlank(message = "Name Can't be blank")
	@NotNull(message = "Name Can't be null")
	private String manager;
	@ManyToOne
	Hospital hospital;
	@OneToOne
	Address address;
}
