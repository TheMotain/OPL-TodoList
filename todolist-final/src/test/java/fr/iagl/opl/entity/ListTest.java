package fr.iagl.opl.entity;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {

	@Test
	public void equalsTest(){
		List list1 = new List();
		List list2 = new List();
		List list3 = new List();
		list1.setName("l");
		list2.setName("l");
		list3.setName("n");
		java.util.List<Task> tasks = new ArrayList<Task>();
		list1.setTasks(tasks);
		list2.setTasks(null);
		list3.setTasks(tasks);
		
		Assert.assertEquals(list1, list1);
		Assert.assertEquals(list1, list2);
		Assert.assertNotEquals(list1, null);
		Assert.assertNotEquals(list1, new Task());
		Assert.assertNotEquals(list1, list3);
		Assert.assertNotEquals(list2, list3);
	}
}
