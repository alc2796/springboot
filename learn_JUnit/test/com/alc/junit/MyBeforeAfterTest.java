package com.alc.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	@BeforeAll
	static void BeforeAll() {
	
		System.out.println("BeforeAll");
	}
	
	@AfterAll
	static void AfterAll() {
	
		System.out.println("AfterAll");
	}
	
	@BeforeEach
	void BeforeEach() {
		
		System.out.println("BeforeEach");
		
	}
	
	@AfterEach
	void AfterEach() {
		
		System.out.println("AfterEach");
		
	}
	
	@Test
	void test1() {
		
		System.out.println("test1");
	
	}
	
	@Test
	void test2() {
		
		System.out.println("test2");
	
	}
	
	@Test
	void test3() {
		
		System.out.println("test3");
	
	}

}
