package com.websiteanvat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteanvat.entity.UserEntity;


/**
 * 
 * @author Hello World
 * extends JpaRepository class for executing method to get and alter database
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String name, int status);
	UserEntity findOneByUserName(String name);
}
