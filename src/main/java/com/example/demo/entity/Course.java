package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="course")
//@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c")
//@NamedQuery(name="query_get_courses_with_name_like" , query = "SELECT c FROM Course c WHERE  c.name like '%100%'")
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
		@NamedQuery(name="query_get_courses_with_name_like" , query = "SELECT c FROM Course c WHERE  c.name like '%100%'")
})
public class Course {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	protected Course() {
		super();
	}

	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Course(String name) {
		this.name = name;
	}
} 
