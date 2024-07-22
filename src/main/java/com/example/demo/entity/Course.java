package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "course" )
	private List<Review> reviews = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "courses") 
	private List<Student> students = new ArrayList<>();
	
	
	
	public Course(Integer id, String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate,
			List<Review> reviews, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdatedDate = lastUpdatedDate;
		this.createdDate = createdDate;
		this.reviews = reviews;
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review reviews) {
		this.reviews.add(reviews);	
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);	
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


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", lastUpdatedDate=" + lastUpdatedDate + ", createdDate="
				+ createdDate + "]";
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
