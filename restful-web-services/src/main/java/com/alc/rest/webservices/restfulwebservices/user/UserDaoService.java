package com.alc.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component 
public class UserDaoService {

	// JPA/Hibernate > Database
	//UserDaoService > Static List
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Andres",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Laura",LocalDate.now().minusYears(29)));
		users.add(new User(++usersCount,"Ana",LocalDate.now().minusYears(28)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById (int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream()
			   .filter(predicate)
			   .findFirst().orElse(null);
	}
	
	public void deleteById (int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	

} 
