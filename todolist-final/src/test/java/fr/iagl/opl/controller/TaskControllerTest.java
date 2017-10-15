package fr.iagl.opl.controller;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

import fr.iagl.opl.SpringIntegrationTest;
import fr.iagl.opl.entity.Task;
import fr.iagl.opl.enums.PageEnum;
import fr.iagl.opl.repository.ListRepository;
import fr.iagl.opl.repository.TaskRepository;

public class TaskControllerTest extends SpringIntegrationTest {

	@InjectMocks
	@Autowired
	private TaskController controller;
	
	@Mock
	private TaskRepository taskRepository;
	
	@Mock
	private ListRepository listRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createTaskCallOneTimeSaveMethode(){
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(new fr.iagl.opl.entity.List());
		controller.createTask("list", "name", "description", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save((Task)Mockito.anyObject());
	}
	
	@Test
	public void createTaskRedirectErrorPageWhenTaskNameNull(){
		RedirectView res = controller.createTask("list", null, null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl(),res.getUrl());
	}
	
	@Test
	public void createTaskRedirectErrorPageWhenListNameNull(){
		RedirectView res = controller.createTask(null, "task", null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl(),res.getUrl());
	}

	@Test
	public void createTaskRedirectErrorPageWhenTaskNameIsEmpty(){
		RedirectView res = controller.createTask("list", "", null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl(),res.getUrl());
	}
	
	@Test
	public void createTaskRedirectErrorPageWhenListNameIsEmpty(){
		RedirectView res = controller.createTask("", "task", null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl(),res.getUrl());
	}
	
	@Test
	public void createTaskRedirectToHomePageAfterSave(){
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(new fr.iagl.opl.entity.List());
		RedirectView res = controller.createTask("List", "task", null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.HOME.getUrl(),res.getUrl());
	}
	
	@Test
	public void createTaskWithNonExtistntListRedirectErrorPage(){
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(null);
		RedirectView res = controller.createTask("List", "task", null, Mockito.mock(ModelMap.class));
		Mockito.verify(listRepository, Mockito.times(1)).findByName(Mockito.anyString());
		Mockito.verify(taskRepository, Mockito.times(0)).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_CREATING_TASK.getUrl(),res.getUrl());
	}
	
	@Test
	public void createTaskGoodEntityInitialization(){
		fr.iagl.opl.entity.List list = new fr.iagl.opl.entity.List();
		list.setName("list");
		Mockito.when(listRepository.findByName(Mockito.anyString())).thenReturn(list);
		ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
		controller.createTask("list", "name", "description", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save(taskCaptor.capture());
		List<Task> capturedTask = taskCaptor.getAllValues();
		Assert.assertEquals(1, capturedTask.size());
		Assert.assertEquals(list, capturedTask.get(0).getList());
		Assert.assertEquals("name", capturedTask.get(0).getName());
		Assert.assertEquals("description", capturedTask.get(0).getDescription());
		Assert.assertFalse(capturedTask.get(0).isDone());
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(capturedTask.get(0).getCreation_date());
		Assert.assertEquals(year, cal.get(Calendar.YEAR));
		Assert.assertEquals(month, cal.get(Calendar.MONTH));
		Assert.assertEquals(day, cal.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void doneTaskCallSaveEntityOneTime(){
		Mockito.when(taskRepository.findOne(Mockito.anyLong())).thenReturn(new Task());
		controller.doneTask("1", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save((Task)Mockito.anyObject());
	}
	
	@Test
	public void doneTaskRedirectToErrorPageWhenIdTaskIsNull(){
		RedirectView res = controller.doneTask(null, Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl(), res.getUrl());
	}
	
	@Test
	public void doneTaskRedirectToErrorPageWhenIdTaskIsEmpty(){
		RedirectView res = controller.doneTask("", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl(), res.getUrl());
	}
	
	@Test
	public void doneTaskRedirectToErrorPageWhenIdTaskIsNotLongValue(){
		RedirectView res = controller.doneTask("aze", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.never()).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl(), res.getUrl());
	}
	
	@Test
	public void doneTaskRedirectToHomePageWhenUpdateSuccess(){
		Mockito.when(taskRepository.findOne(Mockito.anyLong())).thenReturn(new Task());
		RedirectView res = controller.doneTask("1", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save((Task)Mockito.anyObject());
		Assert.assertEquals(PageEnum.HOME.getUrl(), res.getUrl());
	}
	
	@Test
	public void doneTaskRetrieveTheOriginalEntityWithTaskId(){
		controller.doneTask("1", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).findOne(Mockito.anyLong());
	}
	
	@Test
	public void doneTaskRedirectToErrorUpdatePageWhenNotEntityFoundForTaskId(){
		Mockito.when(taskRepository.findOne(Mockito.anyLong())).thenReturn(null);
		RedirectView res = controller.doneTask("1", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).findOne(Mockito.anyLong());	
		Assert.assertEquals(PageEnum.ERROR_WHEN_UPDATE_TASK.getUrl(), res.getUrl());
	}
	
	@Test
	public void doneTaskUpdateBooleanDoneToTrueOfRetrieveEntityToPersist(){
		Task task = new Task();
		task.setDone(false);
		Mockito.when(taskRepository.findOne(Mockito.anyLong())).thenReturn(task);
		ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
		controller.doneTask("1", Mockito.mock(ModelMap.class));
		Mockito.verify(taskRepository, Mockito.times(1)).save(taskCaptor.capture());
		List<Task> capturedTask = taskCaptor.getAllValues();
		Assert.assertEquals(1, capturedTask.size());
		Assert.assertEquals(task, capturedTask.get(0));
		Assert.assertTrue(capturedTask.get(0).isDone());
	}
}
