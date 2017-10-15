package fr.iagl.opl.controller;

import java.util.ArrayList;

import org.junit.Assert;
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
import fr.iagl.opl.enums.ModelAttributeEnum;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;

public class HomeControllerTest extends SpringIntegrationTest{

	@InjectMocks
	@Autowired
	private HomeController controller;
	
	@Mock
	private ListRepository listRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void returnHomePageTest(){
		Assert.assertEquals(PageEnum.HOME.getPage(),controller.home(Mockito.mock(ModelMap.class)));
	}
	
	@Test
	public void putListFormOnMapModelToWelcomeRequestTest(){
		ModelMap model = new ModelMap();
		controller.home(model);
		Assert.assertNotNull(model.get(ModelAttributeEnum.LIST_FORM.getAttribute()));
	}
	
	@Test
	public void getAllTodoListAndPutItOnTheModelMapTest(){
		ModelMap model = new ModelMap();
		java.util.List<List> lists = new ArrayList<>();
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		Mockito.when(listRepository.findAll()).thenReturn(null);
		controller.home(model);
		Mockito.verify(listRepository,Mockito.times(1)).findAll();
		Assert.assertNotNull(model.get(ModelAttributeEnum.TODOLISTS.getAttribute()));
		Assert.assertEquals(3, model.get(ModelAttributeEnum.TODOLISTS.getAttribute()));
	}
}
