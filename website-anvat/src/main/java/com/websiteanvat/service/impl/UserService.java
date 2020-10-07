package com.websiteanvat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websiteanvat.converter.UserConverter;
import com.websiteanvat.dto.UserDTO;
import com.websiteanvat.entity.UserEntity;
import com.websiteanvat.repository.RoleRepository;
import com.websiteanvat.repository.UserRepository;
import com.websiteanvat.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public UserDTO save(UserDTO user) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		UserEntity userEntity = new UserEntity();
		if(user.getId() != null) {
			UserEntity oldUser = userRepository.findOne(user.getId());
			userEntity = userConverter.toEntity(oldUser, user);
		}else {
			userEntity = userConverter.toEntity(user);
			userEntity.setRole(roleRepository.findOneByCode(user.getRoleCode()));
		}
		return userConverter.toDTO(userRepository.save(userEntity));
	}

}
