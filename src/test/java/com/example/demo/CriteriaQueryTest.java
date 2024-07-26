package com.example.demo;
  
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
 
@SpringBootTest(classes = DemoApplication.class )
@Transactional
class CriteriaQueryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	EntityManager em;
	
	
	@Test 
	void criteria_query_basic() {
		
		//1. Use Criteria Builder to create Criteria Query returning the expected result object 
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicates etc using Criteria Builder
		
		//4 Add predicates etc using Criteria Auery
		
		//5 Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> simpleQuery = em.createQuery( cq.select(courseRoot)); //Simple Query

		List<Course> result = simpleQuery.getResultList();
		logger.info("Typed Query => {} "+result);
		 
	}
	
	
	@Test 
	void criteria_query_all_courses_like_100() {
		
		//1. Use Criteria Builder to create Criteria Query returning the expected result object 
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicates etc using Criteria Builder
		Predicate like = cb.like(courseRoot.get("name") , "%100%");
		
		
		//4 Add predicates etc using Criteria Query
		cq.where(like);
		
		//5 Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> simpleQuery = em.createQuery( cq.select(courseRoot)); //Simple Query

		List<Course> result = simpleQuery.getResultList();
		logger.info("Typed Query => {} "+result);
		 
	}
	
	@Test 
	void criteria_query_all_courses_without_students() {
		
		//1. Use Criteria Builder to create Criteria Query returning the expected result object 
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicates etc using Criteria Builder
		Predicate like = cb.isEmpty(courseRoot.get("students"));
		
		
		//4 Add predicates etc using Criteria Query
		cq.where(like);
		
		//5 Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> simpleQuery = em.createQuery( cq.select(courseRoot)); //Simple Query

		List<Course> result = simpleQuery.getResultList();
		logger.info("Without Students s => {} "+result);
		 
	}
	
	@Test 
	void criteria_joins() {
		
		//1. Use Criteria Builder to create Criteria Query returning the expected result object 
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");
		
		
		//4 Add predicates etc using Criteria Query
		
		
		//5 Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> simpleQuery = em.createQuery( cq.select(courseRoot)); //Simple Query

		List<Course> result = simpleQuery.getResultList();
		logger.info("Without Students s => {} "+result);
		 
	}
	
	
	@Test 
	void criteria_left_joins() {
		
		//1. Use Criteria Builder to create Criteria Query returning the expected result object 
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		
		// 2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3 Define predicates etc using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		
		
		//4 Add predicates etc using Criteria Query
		
		
		//5 Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> simpleQuery = em.createQuery( cq.select(courseRoot)); //Simple Query

		List<Course> result = simpleQuery.getResultList();
		logger.info("Left JOIN Without Students s => {} "+result);
		 
	}
	
	 
}
