package fr.iagl.opl.dto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.iagl.opl.entity.Task;
import fr.iagl.opl.utils.DateUtils;

public class ListDTOTest {

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeLineWhenSizeIsLessThanMaxSize() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(ListDTO.MAX_TASK_TO_DISPLAY_ON_A_LINE, dto.getFormatedListToDisplay().get(0).length);
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeLineWhenSizeIsEqualsThanMaxSize() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(ListDTO.MAX_TASK_TO_DISPLAY_ON_A_LINE, dto.getFormatedListToDisplay().get(0).length);
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeLineWhenSizeIsGreaterThanMaxSize() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(ListDTO.MAX_TASK_TO_DISPLAY_ON_A_LINE, dto.getFormatedListToDisplay().get(0).length);
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodNumberOfLineWhenNumberIs0() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		Assert.assertEquals(0, dto.getFormatedListToDisplay().size());
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeLineWhenNumberIs1NotAtTheLimit() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(1, dto.getFormatedListToDisplay().size());
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeLineWhenNumberIs1AtTheLimit() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(1, dto.getFormatedListToDisplay().size());
	}

	@Test
	public void getFormatedListToDisplayCalculateGoodSizeNewLineWhenTheLimitIsOver() {
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertEquals(2, dto.getFormatedListToDisplay().size());
	}
	
	@Test
	public void getFormatedListToDisplayPutDTOWhenArrayLessThanLimit(){
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[0]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[1]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[2]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[3]);
		Assert.assertNull(dto.getFormatedListToDisplay().get(0)[4]);
	}
	
	@Test
	public void getFormatedListToDisplayPutDTOWhenArrayEqualThanLimit(){
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[0]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[1]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[2]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[3]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[4]);
	}
	
	@Test
	public void getFormatedListToDisplayPutDTOWhenArrayGreaterThanLimit(){
		ListDTO dto = new ListDTO();
		List<TaskDTO> tasks = new ArrayList<>();
		dto.setListToDisplay(tasks);
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		tasks.add(new TaskDTO());
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[0]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[1]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[2]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[3]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(0)[4]);
		Assert.assertNotNull(dto.getFormatedListToDisplay().get(1)[0]);
		Assert.assertNull(dto.getFormatedListToDisplay().get(1)[1]);
		Assert.assertNull(dto.getFormatedListToDisplay().get(1)[2]);
		Assert.assertNull(dto.getFormatedListToDisplay().get(1)[3]);
		Assert.assertNull(dto.getFormatedListToDisplay().get(1)[4]);
	}

	@Test
	public void mapListTaskEntityToListTaskDTOReturnSameNumberOfEntityTest() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		ListDTO dto = new ListDTO();
		dto.mapListTaskEntityToListTaskDTO(tasks);
		Assert.assertEquals(tasks.size(), dto.getListToDisplay().size());
	}

	@Test
	public void mapListTaskEntityToListTaskDTOReturnSameNumberOfEntity2Test() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		tasks.add(new Task());
		ListDTO dto = new ListDTO();
		dto.mapListTaskEntityToListTaskDTO(tasks);
		Assert.assertEquals(tasks.size(), dto.getListToDisplay().size());
	}

	@Test
	public void mapListTaskEntityToListTaskDTOMappingTest() throws ParseException {
		List<Task> tasks = new ArrayList<>();
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		task1.setId(1L);
		task1.setName("1");
		task1.setDescription("1");
		task1.setDone(false);
		task1.setCreation_date(DateUtils.parseDateStandardFormat("0001-01-01"));
		tasks.add(task1);
		task2.setId(2L);
		task2.setName("2");
		task2.setDescription("2");
		task2.setDone(false);
		task2.setCreation_date(DateUtils.parseDateStandardFormat("0002-02-02"));
		tasks.add(task2);
		task3.setId(3L);
		task3.setName("3");
		task3.setDescription("3");
		task3.setDone(true);
		task3.setCreation_date(DateUtils.parseDateStandardFormat("0003-03-03"));
		tasks.add(task3);
		ListDTO dto = new ListDTO();
		dto.mapListTaskEntityToListTaskDTO(tasks);
		mainloop: for (Task task : tasks) {
			for (TaskDTO taskDTO : dto.getListToDisplay()) {
				if (taskDTO.getId().equals(task.getId()) && taskDTO.getName().equals(task.getName())
						&& taskDTO.getDescription().equals(task.getDescription())
						&& taskDTO.getCreationDate().equals(task.getCreation_date())
						&& taskDTO.isDone() == task.isDone()) {
					continue mainloop;
				}
			}
			Assert.fail();
		}
	}
}
