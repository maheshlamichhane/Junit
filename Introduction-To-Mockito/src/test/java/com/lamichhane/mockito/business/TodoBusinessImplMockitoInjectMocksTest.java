package com.lamichhane.mockito.business;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.lamichhane.mockito.data.api.ToDoService;

//@RunWith(MockitoJUnitRunner.class)
class TodoBusinessImplMockitoInjectMocksTest {
	
	@Rule
	public MockitoRule mockitoRule=MockitoJUnit.rule();
	
	@Mock
	ToDoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	void testRetrieveTodosRelatedToSpring_usingAMock() 
	{
		
		ToDoService todoServiceMock=mock(ToDoService.class);
		List<String> todos=new ArrayList<>();
		todos.add("Learn Spring MVC");
		todos.add("Learn Spring");
		todos.add("Learn To Dance");
		
		when(todoServiceMock.retrieveTodos("Mahesh")).thenReturn(todos);
		
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Mahesh");
		assertEquals(2,filteredTodos.size());
	}
	
	@Test
	void testRetrieveTodosRelatedToSpring_withEmptyList() 
	{
		
		ToDoService todoServiceMock=mock(ToDoService.class);
		List<String> todos=new ArrayList<>();
		
		when(todoServiceMock.retrieveTodos("Mahesh")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Mahesh");
		assertEquals(0,filteredTodos.size());
	}
	
	@Test
	void testRetrieveTodosRelatedToSpring_usingBDD() 
	{
		
		//Given
		ToDoService todoServiceMock=mock(ToDoService.class);
		List<String> todos=new ArrayList<>();
		todos.add("Learn Spring MVC");
		todos.add("Learn Spring");
		todos.add("Learn To Dance");
		
		//when(todoServiceMock.retrieveTodos("Mahesh")).thenReturn(todos);
		given(todoServiceMock.retrieveTodos("Mahesh")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		
		
		//When
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Mahesh");
		
		
		//Then
		assertThat(filteredTodos.size(),is(2));
		
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring_usingBDD() 
	{
		
		//Given
		ToDoService todoServiceMock=mock(ToDoService.class);
		List<String> todos=new ArrayList<>();
		todos.add("Learn Spring MVC");
		todos.add("Learn Spring");
		todos.add("Learn To Dance");
		
		//when(todoServiceMock.retrieveTodos("Mahesh")).thenReturn(todos);
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		
		
		//When
		todoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");
		
		
		//Then
		//verify(todoServiceMock,times(1)).deleteTodo("Learn To Dance");
		then(todoServiceMock).should().deleteTodo("Learn To Dance");
		//verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn To Dance");
		//verify(todoServiceMock,atLeast(5)).deleteTodo("Learn To Dance");
		//verify(todoServiceMock,never()).deleteTodo("Learn Spring MVc");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
		
	}
	
	@Test
	void testDeleteTodosNotRelatedToSpring_usingBDDArgumentCapture() 
	{
		
		//Declare Argument Captor
		//ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);
		
		
		//Given
		ToDoService todoServiceMock=mock(ToDoService.class);
		List<String> todos=new ArrayList<>();
		todos.add("Learn To Rock and Role");
		todos.add("Learn Spring");
		todos.add("Learn To Dance");
		
		//when(todoServiceMock.retrieveTodos("Mahesh")).thenReturn(todos);
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceMock);
		
		
		//When
		todoBusinessImpl.deleteToDosNotRelatedToSpring("Dummy");
		
		
		//Then 
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		//assertThat(stringArgumentCaptor.getValue(),is("Learn To Dance"));
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
		
		
	}

}
