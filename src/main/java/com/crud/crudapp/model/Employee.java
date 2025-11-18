package com.crud.crudapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmpID;
	
	@Column(nullable=false , length=75)
	private String EmployeeName;
	@Column(nullable=true,length=10)
	private String EmpDepartment;
	
	
	
	 // keeps an varaiable in class file only not reflect on DB - used for temp variable handling 
	@Transient 
	private int backend_counter ;
	
}
