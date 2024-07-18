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

import com.example.demo.entity.Course;
 
@SpringBootTest(classes = DemoApplication.class )
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
	
	 
}
