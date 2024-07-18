package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private EntityManager manager;
	
	@Autowired
	public StudentRepository(EntityManager manager) {
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
	
	
	public void playWithEntityManagerexample() {
		Course entity = new Course("Web Services in 100 steps ");
		manager.persist(entity); 

		Course entity1 = new Course("Angular JS in 100 steps  ");
		manager.persist(entity1);
 		manager.flush();

//		manager.clear();// this will clear all contexts from the entitymanager 
//		manager.detach(entity1);// After Using detach() the object in the entityManager will not perform following operations
//		manager.detach(entity);//After Using detach() the object in the entityManager will not perform following operations

		entity.setName("Web Services in 100 steps  - updated");
		entity1.setName("Angular JS 100 steps - updated");
		
		manager.refresh(entity);
		manager.flush();
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 steps ");
		
		manager.persist(course1);
		 
		Course course2 = findById(10001);
		course2.setName("JPA in 50 steps - updated ");
		manager.flush(); 
		 
	}
}
