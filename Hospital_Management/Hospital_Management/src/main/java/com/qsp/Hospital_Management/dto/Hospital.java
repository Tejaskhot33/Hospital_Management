package com.qsp.Hospital_Management.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@NotBlank(message = "Name Can't be blank")
		@NotNull(message = "Name Can't be null")
		private String name;
		@Email(regexp = "[a-z0-9_+$]+@[a-z0-9]+\\.[a-z]{2,3}",message="invalid Email")
		private String email;
		@NotBlank(message = "Name Can't be blank")
		@NotNull(message = "Name Can't be null")
		private String Ceo;

	}



