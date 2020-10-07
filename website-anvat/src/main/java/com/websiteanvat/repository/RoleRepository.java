package com.websiteanvat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteanvat.entity.CategoryEntity;
import com.websiteanvat.entity.RoleEntity;



public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
}
