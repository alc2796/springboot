package com.alc.springboot.learnspringboot;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
					new Course(1, "Learn AWS", "alc"),
					new Course(2, "Learn DevOps", "alc"),
					new Course(3, "Learn Springboot", "alc")
					);
	}
	
}
