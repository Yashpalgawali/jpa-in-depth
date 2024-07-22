package com.example.demo.entity;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

 

@Entity 
public class Student {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable = false) 
	private String name;

	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;	
	 
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
		
			joinColumns=@JoinColumn(name="STUDENT_ID"),
			inverseJoinColumns = @JoinColumn(name="COURSE_ID")
			)
	private List<Course> courses = new ArrayList<>();
	  
	protected Student() {}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + ", courses=" + courses + "]";
	}
 
	public Student(Integer id, String name, Passport passport, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
		this.courses = courses;
	}

	public Student(String string) {
		this.name = string;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse( Course course) {
		this.courses.add(course);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
} 
