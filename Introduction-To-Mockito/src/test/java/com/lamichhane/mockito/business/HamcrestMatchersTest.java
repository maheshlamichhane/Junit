package com.lamichhane.mockito.business;




import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



class HamcrestMatchersTest {

	@Test
	void test() 
	{
		List<Integer> scores=new ArrayList<>();
		scores.add(99);
		scores.add(100);
		scores.add(101);
		scores.add(105);
		
		assertThat(scores,hasSize(4));
		assertThat(scores,hasItems(99,100));
		assertThat(scores,everyItem(greaterThan(90)));
		assertThat(scores,everyItem(lessThan(190)));
		
		assertThat("",isEmptyString());
		assertThat("",isEmptyOrNullString());
		
		Integer marks[]= {1,2,3};
		assertThat(marks,arrayWithSize(3));
		assertThat(marks,arrayContaining(1,2,3));
		assertThat(marks,arrayContainingInAnyOrder(1,3,2));
		
		
		
		
		
	}
	

}
