package com.websiteanvat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.websiteanvat.service.IMenuService;

@Service
public class MenuService implements IMenuService {

	@Override
	public List<String> loadMenu() {
		List<String> menus = new ArrayList<>();
		menus.add("Home");
		menus.add("Contact");
		menus.add("Login");
		menus.add("Signup");
		return menus;
	}

}
