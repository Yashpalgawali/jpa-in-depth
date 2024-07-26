package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import com.example.demo.repository.CourseSpringhRepository;
 
@SpringBootTest(classes = DemoApplication.class )
class CourseSpringDataRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CourseSpringhRepository courserepo;
	 
	
	@Test
	void findByid() {
		Optional<Course> course = courserepo.findById(1047001) ;
		logger.info("Course Is Present => { } "+ course.isPresent());
		assertTrue(course.isPresent());
		
	}
 
	
	@Test
	void findByid2() {
		Optional<Course> course = courserepo.findById(10008) ;
		logger.info("Course Is Present findByid2 => { } "+ course.isPresent());
		assertFalse(course.isPresent());
	}
	
	@Test
	void saveCOurse() {
		 Course course = new Course("KAFKA in 100 steps");
		 courserepo.save(course);
		 logger.info("Saved Course is "+course);
		 course.setName("KAFKA in 100 steps - UPDATED COURSE");
		 
		 logger.info("UPDATED Course is "+course);
		 
	}
	
	@Test
	void getAllCourses() {
		 
		logger.info("All Courses are -> {} "+courserepo.findAll());
		logger.info("COUNT  -> {} "+courserepo.count());
		 
	}
	
	@Test
	void sortAllCourses() {
		 
		Sort sort =  Sort.by(Sort.Direction.DESC, "name" );
		
		logger.info("All Courses are -> {} "+courserepo.findAll(sort));
		logger.info("COUNT  -> {} "+courserepo.count());
		 
	}
	
	@Test
	public void paginationExample() {
		
		PageRequest pageReq =  PageRequest.of(0, 3);// This will create 
				
		Page<Course> firstpage = courserepo.findAll(pageReq);
		
		logger.info("First PAGE are -> {} "+firstpage.getContent() ); // firstpage.getContent() will return the content of the page
		 
	}
 
	@Test
	public void findCourseByName()
	{
		logger.info("Find By Name() -> {} "+courserepo.findByName("Spring security"));
	}
	
	
	@Test
	public void findCourseByNameUsingNamedQuery()
	{
		logger.info("Find By Name() with Named Query -> {} "+courserepo.courseWith100StepsUsingNamedQuery());
	}
 
}
