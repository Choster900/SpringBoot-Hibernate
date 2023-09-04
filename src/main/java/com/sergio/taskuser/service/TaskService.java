package com.sergio.taskuser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.taskuser.mapper.TaskInDTOToTask;
import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.repositoy.TaskRepository;
import com.sergio.taskuser.service.dto.TaskInDTO;

@Service
public class TaskService {
	private final TaskRepository repository;
	private final TaskInDTOToTask mapperTask;
	public TaskService(TaskRepository repository,TaskInDTOToTask mapperTask) {
		this.repository = repository;
		this.mapperTask = mapperTask;
	}
	
	// Crear nueva tarea (necesitamos mapear la informacion que enviamos)
	// Creamos un DTO (data transfer options)
	public Task createNewTask(TaskInDTO taskInDTO) {
		Task task = mapperTask.map(taskInDTO);
		return this.repository.save(task);
	}
	public List<Task> getAllTask(){
		return this.repository.findAll();
	}
	
}
