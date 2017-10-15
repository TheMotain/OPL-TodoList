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
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
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
		Assert.assertEquals(PageEnum.ERROR_LIST_ALREADY_EXISTS.getPage(), result);
	}
	
	@Test
	public void redirecToTodoListsPageAfterCreationListTest(){
		List entity = new List();
		entity.setName("redirectAfterCreation");
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(null);
		String result = controller.createList(entity, Mockito.mock(BindingResult.class), (ModelMap) Mockito.mock(ModelMap.class));
		Assert.assertEquals(PageEnum.HOME.getPage(), result);
	}
	
	@Test
	public void resetMappedListEntityCallListFormOnTheModelMap(){
		ModelMap model = new ModelMap();
		List entity = new List();
		entity.setName("entity");
		model.addAttribute(ModelAttributeEnum.LIST_FORM.getAttribute(), entity);
		controller.createList(entity, Mockito.mock(BindingResult.class), model);
		Assert.assertNull(((List)model.get(ModelAttributeEnum.LIST_FORM.getAttribute())).getName());
	}
	
	@Test
	public void callDeleteEntityTest(){
		String entity = "entity";
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(new List());
		controller.supprimer(entity, Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository,Mockito.times(1)).delete(entity);
	}
	
	@Test
	public void notCallDeleteEntityWhenListNameNotExistTest(){
		String entity = "entity";
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(null);
		controller.supprimer(entity, (ModelMap) Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository, Mockito.times(1)).findByName(Mockito.anyString());
		Mockito.verify(listRepository, Mockito.never()).delete(Mockito.anyString());
	}
	
	@Test
	public void redirecToErrorPageWhenDeleteAndListNameNotExistsTest(){
		String entity = "name";
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(null);
		String result = controller.supprimer(entity, (ModelMap) Mockito.mock(ModelMap.class));
		Assert.assertEquals(PageEnum.ERROR_LIST_NOT_EXISTS.getPage(), result);
	}
	
	@Test
	public void redirecToTodoListsPageAfterSuppressionListTest(){
		String entity = "redirectAfterSuppression";
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(new List());
		String result = controller.supprimer(entity, (ModelMap) Mockito.mock(ModelMap.class));
		Assert.assertEquals(PageEnum.HOME.getPage(), result);
	}
}
