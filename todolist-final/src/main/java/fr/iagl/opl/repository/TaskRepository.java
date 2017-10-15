package fr.iagl.opl.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.entity.List;
import fr.iagl.opl.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	Task findTaskByNameAndList(String name, List list);
	Task findTaskById(Long id);
}
