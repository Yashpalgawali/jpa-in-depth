package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity 
public class Review {

	@Id @GeneratedValue
	private Integer id;
	
	private String description;
	
	private String rating;
	
	
	@ManyToOne
	private Course course;
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", rating=" + rating + ", course=" + course + "]";
	}

	public Review(Integer id, String description, String rating, Course course) {
		super();
		this.id = id;
		this.description = description;
		this.rating = rating;
		this.course = course;
	}

	protected Review() {
		super();
	}

	public Review(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public Review(String description) {
		this.description = description;
	}


	public Review(String description, String rating) {
		super();
		this.description = description;
		this.rating = rating;
	}
	
	
	
} 
