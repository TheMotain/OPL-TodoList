package fr.iagl.opl.dto;

import java.util.ArrayList;
import java.util.List;

import fr.iagl.opl.entity.Task;

public class ListDTO {
	
	public static final int MAX_TASK_TO_DISPLAY_ON_A_LINE = 5;
	
	private List<TaskDTO> listToDisplay;
	
	private String name;

	public ListDTO(){
		this.listToDisplay = new ArrayList<>();
	}
	
	public void setListToDisplay(List<TaskDTO> listToDisplay){
		this.listToDisplay = listToDisplay;
	}
	
	public List<TaskDTO> getListToDisplay() {
		return listToDisplay;
	}
	
	public List<TaskDTO[]> getFormatedListToDisplay(){
		List<TaskDTO[]> output = new ArrayList<>();
		int size = ((int)listToDisplay.size() / MAX_TASK_TO_DISPLAY_ON_A_LINE) + (listToDisplay.size() % MAX_TASK_TO_DISPLAY_ON_A_LINE == 0 ? 0 : 1);
		int end;
		for(int i = 0; i < size;i++){
			TaskDTO[] taskDTO = new TaskDTO[MAX_TASK_TO_DISPLAY_ON_A_LINE];
			end = i * MAX_TASK_TO_DISPLAY_ON_A_LINE + MAX_TASK_TO_DISPLAY_ON_A_LINE;
			if(i == size - 1){
				end = listToDisplay.size() - 1;
			}
			for(int n = i * MAX_TASK_TO_DISPLAY_ON_A_LINE; n <= end; n++){
				taskDTO[n % MAX_TASK_TO_DISPLAY_ON_A_LINE] = listToDisplay.get(n);
			}
			output.add(taskDTO);
		}
		return output;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void mapListTaskEntityToListTaskDTO(List<Task> entities){
		listToDisplay = new ArrayList<>();
		for(Task entity : entities){
			TaskDTO dto = new TaskDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
			dto.setDone(entity.isDone());
			dto.setCreationDate(entity.getCreation_date());
			listToDisplay.add(dto);
		}
	}
}
