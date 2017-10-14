package fr.iagl.opl.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.repository.ListRepository;

public class ListControllerTest extends SpringIntegrationTest {

	@InjectMocks
	@Autowired
	private ListController controller;

	@Mock
	private ListRepository listRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void callPersistEntityTest(){
		List entity = new List();
		controller.createList(entity, Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository, Mockito.times(1)).save(entity);
	}
}
