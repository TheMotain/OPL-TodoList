package fr.iagl.opl.repository;

import org.springframework.data.repository.CrudRepository;

import fr.iagl.opl.entity.Task;

public interface TaskRepository extends CrudRepository<Task, String>{
	/**
	 * Récupère une tâche par son nom
	 * @param name Nom à rechercher
	 * @return Tâche récupérée, null si elle n'existe pas
	 */
	Task findByName(String name);

}
