package com.websiteanvat.service;

import java.util.List;

import com.websiteanvat.dto.CartDTO;

public interface ICartService {
	List<CartDTO> findAllByUserName(String username);
	CartDTO save(CartDTO cart);
	void delete(long id);
}
