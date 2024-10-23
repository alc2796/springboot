package com.alc.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("Hola", "Adios");

	@Test
	void test() {
	
		assertEquals(todos.contains("Hola"), true, "Something went wrong.");
		assertTrue(todos.contains("Adios"), "Something went wrong");
		assertEquals(todos.size(), 2);
		
		//assertEquals (se puede comparar practicamente todo)
		//assertTrue
		//assertFalse
		//assertArrayEquals
	}

}
