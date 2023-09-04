package com.sergio.taskuser.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sergio.taskuser.mapper.UserInDTOToUser;
import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.User;
import com.sergio.taskuser.persistence.entity.repositoy.TaskRepository;
import com.sergio.taskuser.persistence.entity.repositoy.UserRepository;
import com.sergio.taskuser.service.dto.UserInDTO;

@Service
public class UserService {
	private final UserRepository repository;
	private final UserInDTOToUser mapperUser;

	public UserService(UserRepository repository, UserInDTOToUser mapperUser) {
		this.repository = repository;
		this.mapperUser = mapperUser;
	}

	// CREAR UN NUEVO USUARIO :D
	public User createUser(UserInDTO userInDTO) {
		User user = mapperUser.map(userInDTO);
		return this.repository.save(user);
	}

	// Obtener todos los usuarios
	public List<User> getUsers() {
		return this.repository.findAll();
	}

	// Obtener todas los usuarios junto con sus tareas
	public Collection<User> getUsersWithTasks() {
	    return this.repository.usuariosConTareas();

	}
}
