package com.websiteanvat.converter;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.websiteanvat.dto.ProductDTO;
import com.websiteanvat.entity.ProductEntity;


@Component
public class ProductConverter {
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		result.setImage(entity.getImage());
		result.setDetail(entity.getDetail());
		result.setPrice(entity.getPrice().longValue());
		result.setQuantity(entity.getRemainedQuantity());
		result.setCategoryCode(entity.getCategory().getCode());
		result.setId(entity.getId());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setImage(dto.getImage());
		result.setDetail(dto.getDetail());
		result.setPrice(BigDecimal.valueOf(dto.getPrice()));
		result.setRemainedQuantity(dto.getQuantity());
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result, ProductDTO dto) {
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		result.setImage(dto.getImage());
		result.setDetail(dto.getDetail());
		result.setPrice(BigDecimal.valueOf(dto.getPrice()));
		result.setRemainedQuantity(dto.getQuantity());
		return result;
	}
}
