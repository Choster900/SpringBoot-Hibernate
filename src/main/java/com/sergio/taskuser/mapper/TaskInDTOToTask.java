package com.sergio.taskuser.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.TaskStatus;
import com.sergio.taskuser.persistence.entity.User;
import com.sergio.taskuser.persistence.entity.repositoy.UserRepository;
import com.sergio.taskuser.service.dto.TaskInDTO;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

	private final UserRepository userRepository;

	@Autowired
	public TaskInDTOToTask(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Task map(TaskInDTO in) {
		Task task = new Task();
		// User user = new User();

		User user = userRepository.findById(in.getIdUser())
				.orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + in.getIdUser()));

		task.setUser(user); // Asigna el objeto User a la tarea
		task.setTitleTask(in.getTitleTask());
		task.setDescriptionTask(in.getDescriptionTask());
		task.setEtaTask(in.getEtaTask());
		task.setCreatedDateTask(LocalDateTime.now());
		task.setStatusTask(TaskStatus.ON_TIME);
		// TODO Auto-generated method stub
		return task;

	}

}
