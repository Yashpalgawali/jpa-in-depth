package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.entity.Course;
 
@SpringBootTest(classes = DemoApplication.class )
class NativeQueriesTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	EntityManager em;
	
	
	@Test 
	void all_courses_native_query_basic() {
		
//		Query simpleQuery = em.createQuery("SELECT c FROM Course c"  ); //Simple Query
		Query simpleQuery = em.createNativeQuery("select * from course" ,Course.class ); //Named Query
		List result = simpleQuery.getResultList();
		logger.info("select * from course  => {} "+result);
		 
	}
	
	@Test 
	void all_courses_native_query_basic_parametreized() {
		
//		Query simpleQuery = em.createQuery("SELECT c FROM Course c"  ); //Simple Query
		Query simpleQuery = em.createNativeQuery("select * from course where id= ?" ,Course.class ); //Named Query
		simpleQuery.setParameter(1, 10002);
		List result = simpleQuery.getResultList();
		logger.info("select * from course  => {} "+result);
		 
	}
	
	@Test 
	void all_courses_native_query_basic_parameterized_named_parameter() {
		
//		Query simpleQuery = em.createQuery("SELECT c FROM Course c"  ); //Simple Query
		Query simpleQuery = em.createNativeQuery("select * from course where id=:id" ,Course.class ); //Named Query
		simpleQuery.setParameter("id", 10001);
		List result = simpleQuery.getResultList();
		logger.info("select * from course  => {} "+result);
		 
	}
	
	@Test  @Transactional
	void all_courses_native_query_to_update() {
		
//		Query simpleQuery = em.createQuery("SELECT c FROM Course c"  ); //Simple Query
		Query simpleQuery = em.createNativeQuery("update course set last_updated_date=current_timestamp() " ,Course.class ); //Named Query
		
		int result = simpleQuery.executeUpdate();
		logger.info("select * from course  => {} "+result);
		 
	}
	
	 
}
