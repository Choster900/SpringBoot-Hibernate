package com.sergio.taskuser.service.dto;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sergio.taskuser.persistence.entity.User;

import lombok.Data;
@Data
public class TaskInDTO {
	// Definimos la relación con la tabla usuarios
    private Long idUser;
	private String titleTask;
	private String descriptionTask;
	private LocalDateTime etaTask;

}
