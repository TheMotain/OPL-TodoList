package fr.iagl.opl.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Test
	public void saveEntityTest(){
		List entity = new List();
		entity.setName("saveEntityTest");
		listRepository.save(entity);
		Assert.assertNotNull(listRepository.findByName(entity.getName()));
	}
	
	/**
	 * Dans le setup de base de données pour les tests la liste home contient des taches.
	 * Le mapping des contraintes permet de mettre en place les clé étrangères.
	 * Le test a pour but de contrôler que la contrainte delete cascade est active.
	 */
	@Test
	public void deleteCascadeTest(){
		listRepository.delete("home");
		Assert.assertNull(listRepository.findByName("home"));
	}
}
