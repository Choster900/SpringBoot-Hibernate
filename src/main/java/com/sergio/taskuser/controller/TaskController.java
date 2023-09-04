package com.sergio.taskuser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.service.TaskService;
import com.sergio.taskuser.service.dto.TaskInDTO;

@RestController
@RequestMapping("tasks")
public class TaskController {
	private final TaskService taskService;
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	@PostMapping
	public Task createTask(@RequestBody TaskInDTO taskInDTO) {
		return this.taskService.createNewTask(taskInDTO);
	}
	@GetMapping
	public List<Task> getTask(){
		return this.taskService.getAllTask();
	}
}
