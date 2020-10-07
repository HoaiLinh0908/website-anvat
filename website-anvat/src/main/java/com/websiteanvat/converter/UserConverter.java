package com.websiteanvat.converter;

import org.springframework.stereotype.Component;

import com.websiteanvat.dto.UserDTO;
import com.websiteanvat.entity.UserEntity;


@Component
public class UserConverter {
	
	public UserDTO toDTO(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		result.setPhoneNumber(entity.getPhoneNumber());
		result.setAddress(entity.getAddress());
		result.setEmail(entity.getEmail());
		result.setStatus(entity.getStatus());
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setPhoneNumber(dto.getPhoneNumber());
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		result.setStatus(dto.getStatus());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setUserName(dto.getUserName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setPhoneNumber(dto.getPhoneNumber());
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		result.setStatus(dto.getStatus());
		return result;
	}
}
