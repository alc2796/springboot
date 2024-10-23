package com.alc.mockito.mockitodemo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	void simpleTest() {
		
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
		
	}
	
	@Test
	void multipleReturns() {
		
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3).thenReturn(1);
		assertEquals(3, listMock.size());
		assertEquals(1, listMock.size());
	}
	
	@Test
	void specificParameters() {
		
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("String");
		assertEquals("String", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	void genericParameters() {
		
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("String");
		assertEquals("String", listMock.get(0));
		assertEquals("String", listMock.get(3));
	}
}