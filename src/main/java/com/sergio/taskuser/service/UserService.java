package com.sergio.taskuser.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sergio.taskuser.mapper.UserInDTOToUser;
import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.User;
import com.sergio.taskuser.persistence.entity.repositoy.TaskRepository;
import com.sergio.taskuser.persistence.entity.repositoy.UserRepository;
import com.sergio.taskuser.service.dto.UserInDTO;
import com.sergio.taskuser.service.dto.UserWithTasksDTO;

@Service
public class UserService {
	private final UserRepository repository;
	private final TaskRepository repositoryTask;
	private final UserInDTOToUser mapperUser;

	public UserService(UserRepository repository, UserInDTOToUser mapperUser, TaskRepository repositoryTask) {
		this.repository = repository;
		this.mapperUser = mapperUser;
		this.repositoryTask = repositoryTask;
	}

	// CREAR UN NUEVO USUARIO :D
	public User createUser(UserInDTO userInDTO) {
		User user = mapperUser.map(userInDTO);
		return this.repository.save(user);
	}

	// Obtener solo los usuarios
	public List<User> getUsers() {
		return this.repository.findAll();
	}

	// Obtener todas los usuarios junto con sus tareas
	/*
	 * public List<User> getUsersWithTasks() { User user = new User(); List<User>
	 * users = user.getTasksList(); //List<User> users = this.repository.findAll();
	 * 
	 * return user; }
	 */

	// Obtener todas los usuarios junto con sus tareas

	/*
	 * public List<UserWithTasksDTO> getUsersWithTasks() { List<User> users =
	 * repository.findAll(); return users.stream().map(user -> { List<Task> tasks =
	 * repositoryTask.findByUser(user); return new UserWithTasksDTO(user, tasks);
	 * }).collect(Collectors.toList()); }
	 */

	public List<Map<String, Object>> getUsersWithTasks() {
		List<User> users = repository.findAll();
		return users.stream().map(user -> {
			List<Task> tasks = repositoryTask.findByUser(user);
			Map<String, Object> userWithTasks = new HashMap<>();
			userWithTasks.put("idUser", user.getIdUser());
			userWithTasks.put("nameUser", user.getNameUser());
			userWithTasks.put("emailUser", user.getEmailUser());
			userWithTasks.put("birthDateUser", user.getBirthDateUser());
			userWithTasks.put("passwordUser", user.getPasswordUser());
			userWithTasks.put("createdDateUser", user.getCreatedDateUser());
			userWithTasks.put("statusUser", user.getStatusUser());
			userWithTasks.put("tasksList", tasks); // Add tasks as a list
			return userWithTasks;
		}).collect(Collectors.toList());
	}
}