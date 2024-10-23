package com.alc.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_EmptyArray() {

		assertEquals(1, math.calculateSum(new int[] {}));
		
	}
	
	@Test
	void calculateSum_ThreeMembersArray() {
		
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
		
	}

}
