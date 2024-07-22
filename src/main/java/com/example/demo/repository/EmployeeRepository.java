package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private EntityManager manager;
	
	@Autowired
	public EmployeeRepository(EntityManager manager) {
		this.manager = manager;
	}
	 
	public void insertEmployee(Employee employee)
	{ 
		manager.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployee() {
		 return manager.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();
	}
	
	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		 return manager.createQuery("SELECT e FROM PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		 return manager.createQuery("SELECT e FROM FullTimeEmployee e",FullTimeEmployee.class).getResultList();
	}
	
 
	
	
	
}

