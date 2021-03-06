package com.lamichhane.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest 
{

	@Test
	void letsMockListSizeMethod()
	{
		List listmock=mock(List.class);
		when(listmock.size()).thenReturn(2);
		
		assertEquals(2,listmock.size());
		assertEquals(2,listmock.size());
		assertEquals(2,listmock.size());
		
	}
	
	@Test
	void letsMockListSizeMethod_ReturnMultipleValues()
	{
		List listmock=mock(List.class);
		when(listmock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2,listmock.size());
		assertEquals(3,listmock.size());
	}
	
	@Test
	void letsMockListGet()
	{
		List listmock=mock(List.class);
		when(listmock.get(0)).thenReturn("in 28 minutes");
		//when(listmock.get(anyInt())).thenReturn("in 28 minutes");
		//when(listmock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		assertEquals("in 28 minutes",listmock.get(0));
		assertEquals(null,listmock.get(1));
		
		//Given:-setup
		//When:-actual method call
		//Then:-asserts
	}
	
	@Test
	void letsMockListGet_UsingBDD()
	{
		//given
		List<String> listmock=mock(List.class);
		given(listmock.get(0)).willReturn("in 28 minutes");
		
		//when
		String firstelement=listmock.get(0);
		
		//then
		assertThat(firstelement,is("in 28 minutes"));
		
	}

}
