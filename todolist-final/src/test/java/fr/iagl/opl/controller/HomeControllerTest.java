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
import fr.iagl.opl.dto.ListDTO;
import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;
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
		Mockito.when(listRepository.findAll()).thenReturn(new ArrayList<List>());
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
	
	@SuppressWarnings("rawtypes")
	@Test
	public void getAllTodoListAndPutItOnTheModelMapTest(){
		ModelMap model = new ModelMap();
		java.util.List<List> lists = new ArrayList<>();
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		Mockito.when(listRepository.findAll()).thenReturn(lists);
		controller.home(model);
		Mockito.verify(listRepository,Mockito.times(1)).findAll();
		Assert.assertNotNull(model.get(ModelAttributeEnum.TODOLISTS.getAttribute()));
		Assert.assertEquals(3, ((java.util.List)model.get(ModelAttributeEnum.TODOLISTS.getAttribute())).size());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void getAllTodoListPutOnModelMapListDTOObjectTest(){
		ModelMap model = new ModelMap();
		java.util.List<List> lists = new ArrayList<>();
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		lists.add(Mockito.mock(List.class));
		Mockito.when(listRepository.findAll()).thenReturn(lists);
		controller.home(model);
		for(Object obj : (java.util.List)model.get(ModelAttributeEnum.TODOLISTS.getAttribute())){
			Assert.assertTrue(obj instanceof ListDTO);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllTodoListPutOnModelANameMappingOfListEntityToListDTOTest(){
		ModelMap model = new ModelMap();
		java.util.List<List> lists = new ArrayList<>();
		List list1 = new List();
		list1.setName("l1");
		list1.setTasks(new ArrayList<>());
		List list2 = new List();
		list2.setName("l2");
		list2.setTasks(new ArrayList<>());
		List list3 = new List();
		list3.setName("l3");
		list3.setTasks(new ArrayList<>());
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		Mockito.when(listRepository.findAll()).thenReturn(lists);
		controller.home(model);
		for(ListDTO dto : (java.util.List<ListDTO>)model.get(ModelAttributeEnum.TODOLISTS.getAttribute())) {
			List tmpObj = new List();
			tmpObj.setName(dto.getName());
			if(!lists.contains(tmpObj)){
				Assert.fail();
			}
		}
	}
	
	@Test
	public void getAllTodoListIncludeGetAllTaskFromEachListTest(){
		java.util.List<List> lists = new ArrayList<>();
		List list1 = Mockito.mock(List.class);
		List list2 = Mockito.mock(List.class);
		List list3 = Mockito.mock(List.class);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		Mockito.when(listRepository.findAll()).thenReturn(lists);
		controller.home(Mockito.mock(ModelMap.class));
		Mockito.verify(list1, Mockito.times(1)).getTasks();
		Mockito.verify(list2, Mockito.times(1)).getTasks();
		Mockito.verify(list3, Mockito.times(1)).getTasks();
	}
	
	@Test
	public void getAllTodoListIncludeMapAllTaskFromEachListFromTaskEntityToTaskDTO(){
		java.util.List<List> lists = new ArrayList<>();
		java.util.List<Task> tasks = new ArrayList<>();
		List list1 = Mockito.mock(List.class);
		List list2 = Mockito.mock(List.class);
		List list3 = Mockito.mock(List.class);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		Task task1 = Mockito.mock(Task.class);
		Task task2 = Mockito.mock(Task.class);
		Task task3 = Mockito.mock(Task.class);
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		Mockito.when(listRepository.findAll()).thenReturn(lists);
		Mockito.when(list1.getTasks()).thenReturn(tasks);
		Mockito.when(list2.getTasks()).thenReturn(tasks);
		Mockito.when(list3.getTasks()).thenReturn(tasks);
		controller.home(Mockito.mock(ModelMap.class));
		Mockito.verify(task1, Mockito.times(3)).getId();
		Mockito.verify(task1, Mockito.times(3)).getCreation_date();
		Mockito.verify(task1, Mockito.times(3)).getDescription();
		Mockito.verify(task1, Mockito.times(3)).getName();
		Mockito.verify(task2, Mockito.times(3)).getId();
		Mockito.verify(task2, Mockito.times(3)).getCreation_date();
		Mockito.verify(task2, Mockito.times(3)).getDescription();
		Mockito.verify(task2, Mockito.times(3)).getName();
		Mockito.verify(task3, Mockito.times(3)).getId();
		Mockito.verify(task3, Mockito.times(3)).getCreation_date();
		Mockito.verify(task3, Mockito.times(3)).getDescription();
		Mockito.verify(task3, Mockito.times(3)).getName();
	}
}
