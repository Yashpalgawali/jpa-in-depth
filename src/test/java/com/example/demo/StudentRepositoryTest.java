package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import javax.persistence.EntityManager;
 
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;


@SpringBootTest(classes = DemoApplication.class )
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	StudentRepository studerepo;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	void retriveStudentAndPassportDetails() {
		 
		 Student student = em.find(Student.class, 2002);
		 logger.info("Student is {} "+student);
		 logger.info("Passport is {} "+student.getPassport());
		 assertEquals("Dante", student.getName());
	}
	
	@Test
	@Transactional
	void retrivePassportAndStudentDetails() {
		 
		 Passport passport= em.find(Passport.class, 4001);
		 logger.info("passport is { } "+passport);
		 logger.info("Student is { } "+passport.getStudent()); 
	}
	
	@Test  
	void someTest() {
		studerepo.someOperationToUnderstandPersistentContext();
	}

}
