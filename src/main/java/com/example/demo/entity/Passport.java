package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

 

@Entity 
public class Passport {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String number;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", number=" + number + "]";
	}

	protected Passport() {
		super();
	}

	public Passport(Integer id, String number) {
		super();
		this.id = id;
		this.number = number;
	}
	
	public Passport(String number) {
		this.number = number;
	}
} 
