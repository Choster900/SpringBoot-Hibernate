package com.sergio.taskuser.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergio.taskuser.persistence.entity.User;
import com.sergio.taskuser.service.UserService;
import com.sergio.taskuser.service.dto.UserInDTO;

@RestController
@RequestMapping("users")
	
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public User createUser(@RequestBody UserInDTO userInDTO) {
		return this.userService.createUser(userInDTO);
	}
	@GetMapping
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	
	@GetMapping("/withTask")
	public Collection<User> getUsersWithTask(){
		return this.userService.getUsersWithTasks();
	}
}

