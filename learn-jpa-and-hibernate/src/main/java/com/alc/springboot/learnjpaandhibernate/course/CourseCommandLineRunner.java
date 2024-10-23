package com.alc.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alc.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	//Spring JDBC
//	@Autowired
//	private CourseJdbcRepository repository;
	
	//JPA
//	@Autowired
//	private CourseJPARepository repository;
	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		repository.insert(new Course(1, "Learn JDBC", "Andres LC"));
//		repository.insert(new Course(2, "Learn SpringBoot", "Andres LC"));
//		repository.insert(new Course(3, "Learn Maven", "Andres LC"));
//		repository.deleteById(2);
//		System.out.println(repository.findById(1));
//		System.out.println(repository.findById(3));
//	}
	
	//Spring JPA
	@Autowired
	private CourseSpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "Learn JDBC", "Andres LC"));
		repository.save(new Course(2, "Learn SpringBoot", "Andres LC"));
		repository.save(new Course(3, "Learn Maven", "Andres LC"));
		repository.deleteById(2l);
//		System.out.println(repository.findById(1l));
//		System.out.println(repository.findById(3l));
		
//		System.out.println(repository.findAll());
//		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Andres LC"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn JDBC"));
		
	}

}




















