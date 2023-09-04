package com.sergio.taskuser.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.sergio.taskuser.persistence.entity.StatusUser;
import com.sergio.taskuser.persistence.entity.User;
import com.sergio.taskuser.service.dto.UserInDTO;

@Component
public class UserInDTOToUser implements IMapper<UserInDTO, User>{

	@Override
	public User map(UserInDTO in) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setNameUser(in.getNameUser());
		user.setEmailUser(in.getEmailUser());
		user.setBirthDateUser(in.getBirthDateUser());
		user.setPasswordUser(in.getPasswordUser());
		user.setCreatedDateUser(LocalDateTime.now());
		user.setStatusUser(StatusUser.ACTIVO);
		return user;
	}

}
