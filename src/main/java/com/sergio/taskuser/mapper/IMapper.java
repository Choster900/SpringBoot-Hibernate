package com.sergio.taskuser.mapper;

public interface IMapper <InputType,OutputType>{
	//Mapear 
	public OutputType map(InputType in);
}
