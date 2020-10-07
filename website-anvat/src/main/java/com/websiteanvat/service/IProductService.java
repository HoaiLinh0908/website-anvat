package com.websiteanvat.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.websiteanvat.dto.ProductDTO;



public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> findByCategoryCode(String code,Pageable pageable);
	Integer getTotalItemByCategoryCode(String code);
	Integer getTotalItem();
	ProductDTO findByCode(String code);
	ProductDTO findOneById(Long id);
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
}
