package com.websiteanvat.controllers.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.websiteanvat.dto.CartDTO;
import com.websiteanvat.dto.ProductDTO;
import com.websiteanvat.service.ICartService;
import com.websiteanvat.service.IProductService;
import com.websiteanvat.util.SecurityUtils;

@Controller
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView cartPage() {
		ModelAndView mav = new ModelAndView("web/cart");
		List<CartDTO> carts = cartService.findAllByUserName(SecurityUtils.getPrincipal().getUsername());
		List<ProductDTO> products = new ArrayList<>();
		for(CartDTO cart : carts) {
			products.add(productService.findOneById(cart.getProductId()));
		}
		mav.addObject("carts", carts);
		mav.addObject("products", products);
		return mav;
	}
}
