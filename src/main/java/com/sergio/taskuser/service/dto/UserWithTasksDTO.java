package com.sergio.taskuser.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.User;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserWithTasksDTO {
	private User user;
	private List<Task> tasks;

	public UserWithTasksDTO(User user, List<Task> tasks) {
		this.user = user;
		this.tasks = tasks;
	}
}
