package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
 
@SpringBootTest(classes = DemoApplication.class )
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	com.example.demo.repository.CourceRepository  repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	void retriveStudentAndPassportDetails() {
		 
		 Student student = em.find(Student.class, 2002);
		 logger.info("Student is {} "+student);
		 logger.info("Passport is {} "+student.getPassport());
		 assertEquals("Dante", student.getName());
	}
	
	 
	
	@Test @DirtiesContext
	void deleteByid_Basic() {
		 
		repository.deleteById(1); 
		assertNull(repository.findById(1));
	}
	
	@Test @DirtiesContext
	void save_Basic() {
		 
		Course course = repository.findById(1);	
		assertEquals("REST EXAMPLE" , course.getName());
		
		//update details
		course.setName("REST EXAMPLE - Updated");
		
		repository.save(course);
		assertEquals("REST EXAMPLE - UPdated", course.getName());
		
	}
	
	@Test @DirtiesContext
	void playWithEntityManager() {
		 
		 repository.playWithEntityManager();
		
	}

//	@Test
//	public void playWithEntityManager() {
//		
//	}
}
