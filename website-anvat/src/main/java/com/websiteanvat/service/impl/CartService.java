package com.websiteanvat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websiteanvat.converter.CartConverter;
import com.websiteanvat.dto.CartDTO;
import com.websiteanvat.entity.CartEntity;
import com.websiteanvat.entity.ProductEntity;
import com.websiteanvat.entity.UserEntity;
import com.websiteanvat.repository.CartRepository;
import com.websiteanvat.repository.ProductRepository;
import com.websiteanvat.repository.UserRepository;
import com.websiteanvat.service.ICartService;
import com.websiteanvat.util.SecurityUtils;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<CartDTO> findAllByUserName(String username) {
		List<CartDTO> result = new ArrayList<>();
		List<CartEntity> carts = cartRepository.findByUserUserName(username);
		for(CartEntity cart : carts) {
			result.add(cartConverter.toDTO(cart));
		}
		return result;
	}

	@Override
	@Transactional
	public CartDTO save(CartDTO cartDTO) {
		CartEntity cartEntity = new CartEntity();
		cartDTO = checkCart(cartDTO);
		if(cartDTO.getId() != null) {
			CartEntity oldCart = cartRepository.findOne(cartDTO.getId());
			cartEntity = cartConverter.toEntity(cartDTO, oldCart);
		}else {
			ProductEntity product = productRepository.findOneByCode(cartDTO.getProductCode());
			UserEntity user = userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
			cartEntity = cartConverter.toEntity(cartDTO);
			cartEntity.setProduct(product);
			cartEntity.setUser(user);
		}
		return cartConverter.toDTO(cartRepository.save(cartEntity));
	}
	
	//kiem tra xem duoi database co cart nao co trung productCode va userName khong.
	public CartDTO checkCart(CartDTO cartDTO) {
		CartDTO newCart = new CartDTO();
		List<CartEntity> cartEntitys = cartRepository.findAll();
		String code = cartDTO.getProductCode();
		String userName = SecurityUtils.getPrincipal().getUsername();
		for(CartEntity cart : cartEntitys) {
			if(checkOne(code, userName, cart)) {
				newCart = cartConverter.toDTO(cart);
				newCart.setQuantity(cartDTO.getQuantity() + cartConverter.toDTO(cart).getQuantity());
				return newCart;
			}
		}
		return cartDTO;
	}
	
	public boolean checkOne(String code, String userName, CartEntity cartEntity) {
		if(code.equalsIgnoreCase(cartConverter.toDTO(cartEntity).getProductCode())
				&& userName.equalsIgnoreCase(cartConverter.toDTO(cartEntity).getUserName()))
			return true;
		return false;
	}

	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}