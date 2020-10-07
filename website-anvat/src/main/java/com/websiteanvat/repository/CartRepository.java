package com.websiteanvat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteanvat.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
	List<CartEntity> findByUserUserName(String userName);
}
