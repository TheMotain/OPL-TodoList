package fr.iagl.opl.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import fr.iagl.opl.SpringIntegrationTest;

public class HomeControllerTest extends SpringIntegrationTest{

	@Autowired
	private HomeController controller;
	
	@Test
	public void returnHomePageTest(){
		Assert.assertEquals("todolists",controller.welcome(Mockito.mock(ModelMap.class)));
	}
	
	@Test
	public void putListFormOnMapModelToWelcomeRequestTest(){
		ModelMap model = new ModelMap();
		controller.welcome(model);
		Assert.assertNotNull(model.get("listForm"));
	}
}
