package com.example.demo.repository;

import javax.persistence.EntityManager;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

@Repository
@Transactional
public class CourceRepository {

	
	private EntityManager manager;
	
	@Autowired
	public CourceRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Course save(Course course)
	{
		if(course.getId()==null)
		{
			  manager.persist(course);
		}
		else {
			manager.merge(course);
		}
		return course;
	}
	
	public Course findById(int id)
	{
		Course course = manager.find(Course.class, id);
		return course;
	}
	
	public void deleteById(int id)
	{
		Course course = manager.find(Course.class, id);
		manager.remove(course);
	}
}
