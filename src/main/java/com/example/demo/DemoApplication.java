package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourceRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CourceRepository courserepository;
	
	@Autowired
	StudentRepository studrepo;
	
	@Autowired
	EmployeeRepository emprepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
//		List<Review> revlist = new ArrayList<>();
//		
//		Review review = new Review("Greatest Course","5");
//		Review review1 = new Review("HATS OFF","5");
//		revlist.add(review);
//		revlist.add(review1);
		 
		//repository.playWithEntityManager();
		//courserepository.addReviesForCourse();
		
		//courserepository.addHardCodedReviesForCourse();
		
		//courserepository.addReviesForCourse(10003,revlist);
		
		//studrepo.insertHardCodedStudentAndCourse();
		//studrepo.insertStudentAndCourse(new Course("ZOOKEEPER IN 100 steps"), new Student("JACK"));
		
//		emprepo.insertEmployee(new FullTimeEmployee(new BigDecimal(10000), "JACK"));
//		emprepo.insertEmployee(new PartTimeEmployee(new BigDecimal(500), "JILL"));
		
		//logger.info("ALL Employees { }"+emprepo.retrieveAllEmployee());
		 
//		logger.info("ALL FULL Time Employees { }"+emprepo.retrieveAllFullTimeEmployees());
//		logger.info("ALL Part Time Employees { }"+emprepo.retrieveAllPartTimeEmployees());
	}

}
