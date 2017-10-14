package fr.iagl.opl.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.entity.List;

public class ListRepositoryTest extends SpringIntegrationTest {

	@Autowired
	private ListRepository listRepository;

	@Test
	public void findByNameTest(){
		List entity = listRepository.findByName("work");
		Assert.assertNotNull(entity);
		Assert.assertEquals("work", entity.getName());
	}
}
