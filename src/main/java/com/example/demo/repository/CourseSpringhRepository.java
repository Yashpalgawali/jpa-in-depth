package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringhRepository extends JpaRepository<Course, Integer> {
 	
	List<Course> findByName(String name); // This will find the List of Course by Name
	
	List<Course> countByName(String name); // This will find the count of Course by Name
	
	List<Course> findByNameAndId(String name,Integer id);// This will find the List of Course by Name And the ID
	
	List<Course> findByNameOrderById(String name); // This will find the List of Course by Name and Order it by ID
	 
	List<Course> findByNameOrderByIdDesc(String name); // This will find the List of Course by Name and Order it by ID in Descending manner
	 
	List<Course> deleteByName(String name); // This will delete the List of Course by Name
 
	// By Using @Query annotation
	
	@Query("SELECT c FROM Course c WHERE c.name LIKE '%100 steps'")
	List<Course> courseWith100Steps(); // This will find the List of Course by Name
	
	@Query(name="query_get_courses_with_name_like")
	List<Course> courseWith100StepsUsingNamedQuery(); // This will find the List of Course by Name
}