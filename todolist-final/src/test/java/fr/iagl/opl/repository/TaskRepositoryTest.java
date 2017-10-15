package fr.iagl.opl.repository;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.utils.DateUtils;

public class TaskRepositoryTest extends SpringIntegrationTest {
	
	@Autowired
	private TaskRepository repository;
	
	@Test
	public void findByNameAndListTest() throws ParseException{
		List list = new List();
		list.setName("work");
		Task task = repository.findTaskByNameAndList("meeting", list);
		Assert.assertNotNull(task);
		Assert.assertEquals(new Long(0), task.getId());
		Assert.assertEquals("meeting", task.getName());
		Assert.assertEquals("work", task.getList().getName());
		Assert.assertEquals("todo", task.getDescription());
		Assert.assertEquals(DateUtils.parseDateStandardFormat("2017-10-11"), task.getCreation_date());
		Assert.assertFalse(task.isDone());
	}
}
