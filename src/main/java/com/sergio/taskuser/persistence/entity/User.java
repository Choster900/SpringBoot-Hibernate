package com.sergio.taskuser.persistence.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String nameUser;
	private String emailUser;
	private java.util.Date birthDateUser; // Utiliza LocalDate para representar la fecha
	private String passwordUser;
	private LocalDateTime createdDateUser;
	private StatusUser statusUser;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JsonManagedReference
	private List<Task> tasksList = new ArrayList<>();
	
}
