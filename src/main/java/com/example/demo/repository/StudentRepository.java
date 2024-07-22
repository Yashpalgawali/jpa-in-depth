package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

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
		if(course.getId()==null) {
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
	
	
	public  void someOperationToUnderstandPersistentContext() {
		//Database Operation 1 - Retrieve Student by ID
		 Student student = manager.find(Student.class, 2002);
		// PersitenceContext(student)
		 
		 
		//Database Operation 2 - Retrieve Passport
		 Passport passport = student.getPassport();
		//PersitenceContext(student , passport)
		 
		//Database Operation 3 - Update Passport
		 passport.setNumber("NEW-UPDATED");
		//PersitenceContext(student , passport++)
		
		 
		 //Database Operation 4 - Update Student
		 student.setName("Updated Name ");
		//PersitenceContext(student++ , passport++)
	}
	
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Jack");
		
		Course course = new Course("KAFKA in 100 steps");
		
		manager.persist(course);
		manager.persist(student);
		
		student.addCourse(course);
		course.addStudent(student);
		
		manager.persist(student); 
		
	}
	
	
	public void insertStudentAndCourse(Course course,Student student) {
//		Student student = new Student("Jack");
//		
//		Course course = new Course("KAFKA in 100 steps");
		
		student.addCourse(course);
		course.addStudent(student);
		
		manager.persist(course);
		manager.persist(student);
		
		
		
		manager.persist(student); 
		
	}
}
