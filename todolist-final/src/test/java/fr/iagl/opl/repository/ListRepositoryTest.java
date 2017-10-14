package fr.iagl.opl.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.entity.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class ListRepositoryTest extends SpringIntegrationTest {

	@Autowired
	private ListRepository listRepository;

	@Test
	public void findByNameTest(){
		List entity = listRepository.findByName("work");
		Assert.assertNotNull(entity);
		Assert.assertEquals("work", entity.getName());
	}
	
	@Test
	public void saveEntityTest(){
		List entity = new List();
		entity.setName("saveEntityTest");
		listRepository.save(entity);
		Assert.assertNotNull(listRepository.findByName(entity.getName()));
	}
}
