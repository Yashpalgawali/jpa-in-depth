package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{


	private BigDecimal salary;

	protected FullTimeEmployee() {  }

	public FullTimeEmployee(BigDecimal salary, String name) {
		super(name);
		this.salary = salary;
		 
	}
	
	
	
}