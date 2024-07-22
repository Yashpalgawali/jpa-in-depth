package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{


	private BigDecimal hourlyWage;

	protected PartTimeEmployee() {  }

	public PartTimeEmployee(BigDecimal hourlywage, String name) {
		super(name);
		this.hourlyWage = hourlywage;
		 
	}
	
	
	
}