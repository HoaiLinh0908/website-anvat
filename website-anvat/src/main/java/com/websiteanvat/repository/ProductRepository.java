package com.websiteanvat.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websiteanvat.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	List<ProductEntity> findByCategoryCode(String code,Pageable pageable);
	long countByCategoryCode(String code);
	ProductEntity findOneByCode(String code);
}
