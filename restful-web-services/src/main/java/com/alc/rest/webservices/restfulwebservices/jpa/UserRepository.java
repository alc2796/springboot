package com.alc.rest.webservices.restfulwebservices.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alc.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
