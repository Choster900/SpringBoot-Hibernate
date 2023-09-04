package com.sergio.taskuser.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTask;

	@ManyToOne
	@JoinColumn(name = "id_user") // Nombre de la columna que contendrá la clave foránea en la tabla Task
	@JsonBackReference
	private User user;

	private String titleTask;
	private String descriptionTask;
	private LocalDateTime createdDateTask;
	private LocalDateTime etaTask;
	private boolean finishedTask;
	private TaskStatus statusTask;

}
