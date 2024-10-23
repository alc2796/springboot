package com.alc.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alc.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long>{

	List<Course> findByAuthor (String author);
	List<Course> findByName (String name);

}
	