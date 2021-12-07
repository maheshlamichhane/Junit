package com.lamichhane.mockito.data.api;

import java.util.ArrayList;
import java.util.List;


public class TodoServiceStub implements ToDoService
{

	@Override
	public List<String> retrieveTodos(String user) 
	{
		List<String> list=new ArrayList<>();
		list.add("Learn Spring MVC");
		list.add("Learn Spring");
		list.add("Learn To Dance");
		
		return list;
	}

	@Override
	public void deleteTodo(String todo) 
	{
		
	}

}
