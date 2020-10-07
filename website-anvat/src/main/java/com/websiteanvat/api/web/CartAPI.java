package com.websiteanvat.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websiteanvat.dto.CartDTO;
import com.websiteanvat.service.ICartService;

@RestController(value = "cartAPIOfWeb")
public class CartAPI {
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/api/cart")
	public CartDTO createCart(@RequestBody CartDTO cartDTO) {
		return cartService.save(cartDTO);
	}
	
	@PutMapping("/api/cart")
	public CartDTO updateCart(@RequestBody CartDTO cartDTO) {
		return cartService.save(cartDTO);
	}
	
	@DeleteMapping("/api/news")
	public void deleteCarts(@RequestBody long id) {
		cartService.delete(id);
	}
}
