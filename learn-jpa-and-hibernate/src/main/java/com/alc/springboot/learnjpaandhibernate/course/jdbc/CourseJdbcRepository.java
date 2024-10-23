package com.alc.springboot.learnjpaandhibernate.course.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alc.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = 
			"""
			INSERT INTO courses (id, name, author)
			VALUES (?, ?, ?);
			""";
	
	private static String DELETE_QUERY = 
			"""
			DELETE FROM courses WHERE id=?
			""";
	
	private static String FINDBYID_QUERY =
			"""
			SELECT * FROM courses
			WHERE id=?	
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		//Result set --> Bean --> RowMap
		return springJdbcTemplate.queryForObject(FINDBYID_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);

	}
}

