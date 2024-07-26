package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
 
@SpringBootTest(classes = DemoApplication.class )
@Transactional
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	EntityManager em;
	
	
	@Test 
	void all_courses_jpql_basic() {
		
//		Query simpleQuery = em.createQuery("SELECT c FROM Course c"  ); //Simple Query
		Query simpleQuery = em.createNamedQuery("query_get_all_courses"  ); //Named Query
		List result = simpleQuery.getResultList();
		logger.info("Select c from Course c => {} "+result);
		 
	}
	
	@Test 
	void all_courses_jpql_typed_query() {
		
//		TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c",Course.class ); // Typed Query
		TypedQuery<Course> createQuery = em.createNamedQuery("query_get_all_courses",Course.class ); // Named Query
		List<Course> result = createQuery.getResultList();
		logger.info("Select c from Course c => {} "+result);
		 
	}
	
	@Test 
	void all_courses_jpql_where_typed_query() {
		
//		TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c WHERE  c.name like '%100%'",Course.class );// TypedQuery
		TypedQuery<Course> createQuery = em.createNamedQuery("query_get_courses_with_name_like",Course.class ); // Named Query
		List<Course> result = createQuery.getResultList();
		logger.info("Select c from Course c => {} "+result);
		 
	}
	
	@Test 
	void jpql_courses_without_students() {
		
		TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c WHERE  c.students IS EMPTY ",Course.class );// TypedQuery

		List<Course> result = createQuery.getResultList();
		logger.info("SELECT c from Course c => {} "+result);
		 
	}
	
	
	@Test 
	void jpql_courses_with_at_least_2_students() {
		
		TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c WHERE  size(c.students) >=2 ",Course.class );// TypedQuery

		List<Course> result = createQuery.getResultList();
		logger.info("SELECT c from Course c => {} "+result);
		 
	}
	
	@Test 
	void jpql_courses_order_by_students() {
		
		TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c ORDER BY   size(c.students) DESC ",Course.class );// TypedQuery Descending order

	//	TypedQuery<Course> createQuery = em.createQuery("SELECT c FROM Course c ORDER BY   size(c.students)  ",Course.class );// TypedQuery Ascending Order
		List<Course> result = createQuery.getResultList();
		logger.info("SELECT c FROM Course c ORDER BY  size(c.students)  => {} "+result);
		 
	}
	
	@Test 
	void jpql_students_with_passports_in_certain_pattern() {
		
		TypedQuery<Student> createQuery = em.createQuery("SELECT s FROM Student s  WHERE s.passport.number  LIKE '%123%'",Student.class );// TypedQuery Descending order

	  	List<Student> result = createQuery.getResultList();
		logger.info("SELECT s FROM Student s  WHERE s.passport  LIKE '%23%' => {} "+result);
		 
	}

	@Test
	void joins()
	{
		Query query = em.createQuery("SELECT c, s FROM Course c JOIN c.students s"  );// 

	  	List<Object[]> result = query.getResultList();
		logger.info("Result Size = "+result.size());
		
		for(Object[] res : result) {
			logger.info("Student => {} , XCourse=>{}"+ res[0],res[1]);
		} 
	}
	

	@Test
	void left_joins()
	{
		Query query = em.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s"  );// 

	  	List<Object[]> result = query.getResultList();
		logger.info("Result Size = "+result.size());
		
		for(Object[] res : result) {
			logger.info("Student => {} , XCourse=>{}"+ res[0],res[1]);
		} 
	}
	
	
	@Test
	void cross_joins()
	{
		Query query = em.createQuery("SELECT c, s FROM Course c ,Student s "  );// 

	  	List<Object[]> result = query.getResultList();
		logger.info("Result Size = "+result.size());
		
		for(Object[] res : result) {
			logger.info("Student => {} , XCourse=>{}"+ res[0],res[1]);
		} 
	}
	 
}
