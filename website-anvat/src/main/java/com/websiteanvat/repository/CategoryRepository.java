package com.websiteanvat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteanvat.entity.CategoryEntity;



public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
