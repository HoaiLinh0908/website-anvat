package com.websiteanvat.converter;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.websiteanvat.dto.CartDTO;
import com.websiteanvat.entity.CartEntity;

@Component
public class CartConverter {
	public CartDTO toDTO(CartEntity entity) {
		CartDTO result = new CartDTO();
		result.setPrice(entity.getPrice().longValue());
		result.setQuantity(entity.getQuantity());
		result.setProductId(entity.getProduct().getId());
		result.setId(entity.getId());
		result.setUserId(entity.getUser().getId());
		result.setProductCode(entity.getProduct().getCode());
		result.setUserName(entity.getUser().getUserName());
		return result;
	}
	
	public CartEntity toEntity(CartDTO dto) {
		CartEntity result = new CartEntity();
		result.setPrice(BigDecimal.valueOf(dto.getPrice()));
		result.setQuantity(dto.getQuantity());
		return result;
	}
	
	public CartEntity toEntity(CartDTO dto, CartEntity result) {
		result.setPrice(BigDecimal.valueOf(dto.getPrice()));
		result.setQuantity(dto.getQuantity());
		return result;
	}
}
