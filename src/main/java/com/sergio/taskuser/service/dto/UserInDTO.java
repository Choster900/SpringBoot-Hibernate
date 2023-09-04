package com.sergio.taskuser.service.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;

	@Data
	@Getter
public class UserInDTO {
	private String nameUser;
	private String emailUser;
    //@Column(name = "birth_date_user", columnDefinition = "DATE")
    private java.util.Date birthDateUser; // Utiliza LocalDate para representar la fecha
	private String passwordUser;
	
	
}
