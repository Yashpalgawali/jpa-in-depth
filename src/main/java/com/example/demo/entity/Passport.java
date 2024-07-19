package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

 

@Entity 
public class Passport {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String number;

	@OneToOne(fetch = FetchType.LAZY , mappedBy = "passport")
	private Student student;

	public Passport(Integer id, String number, Student student) {
		super();
		this.id = id;
		this.number = number;
		this.student = student;
	}

//	@Override
//	public String toString() {
//		return "Passport [id=" + id + ", number=" + number + ", student=" + student + "]";
//	}

	public Passport() {
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	} 
	
	
} 
