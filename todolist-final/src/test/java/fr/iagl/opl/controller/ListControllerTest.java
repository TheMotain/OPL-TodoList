package fr.iagl.opl.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

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
		controller.createList(entity, (BindingResult) Mockito.mock(BindingResult.class), (ModelMap) Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository, Mockito.times(1)).save(entity);
	}
	
	@Test
	public void notCallPersistEntityWhenListNameAlreadyExistTest(){
		List entity = new List();
		entity.setName("entity");
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(entity);
		controller.createList(entity, Mockito.mock(BindingResult.class), (ModelMap) Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository, Mockito.times(1)).findByName(Mockito.anyString());
		Mockito.verify(listRepository, Mockito.never()).save((List)Mockito.anyObject());
	}
	
	@Test
	public void redirecToErrorPageWhenListNameAlreadyExistsTest(){
		List entity = new List();
		entity.setName("entity");
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(entity);
		String result = controller.createList(entity, Mockito.mock(BindingResult.class), (ModelMap) Mockito.mock(ModelMap.class));
		Assert.assertEquals("errorListAlreadyExists", result);
	}
	
	@Test
	public void redirecToTodoListsPageAfterCreationListTest(){
		List entity = new List();
		entity.setName("redirectAfterCreation");
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(null);
		String result = controller.createList(entity, Mockito.mock(BindingResult.class), (ModelMap) Mockito.mock(ModelMap.class));
		Assert.assertEquals("todolists", result);
	}
}
