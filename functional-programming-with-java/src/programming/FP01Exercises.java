package programming;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot",
										"API", "Microservices",
										"AWS", "PCF", "Azure",
										"Docker", "Kubernetes");
		
		//printAllCoursesInListFunctional(courses);
		//printSpringCoursesInListFunctional(courses);
		//printFourLetterCoursesInListFunctional(courses);
		printCharactersOfAllCoursesInListFunctional(courses);
	}

	private static void printAllCoursesInListFunctional(List<String> courses) {
		
		courses.stream()
		.forEach(System.out::println); //Method reference

	}
	
	private static void printCharactersOfAllCoursesInListFunctional(List<String> courses) {
		
		courses.stream()
		.map(course -> course.length())
		.forEach(System.out::println); //Method reference

	}
	
	private static void printSpringCoursesInListFunctional(List<String> courses) {
		
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println); //Method reference

	}
	
	private static void printFourLetterCoursesInListFunctional(List<String> courses) {
		
		courses.stream()
		.filter(course -> course.length()>=4)
		.forEach(System.out::println); //Method reference

	}

}
