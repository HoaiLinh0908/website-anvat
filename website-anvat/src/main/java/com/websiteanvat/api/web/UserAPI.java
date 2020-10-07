package com.websiteanvat.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websiteanvat.dto.UserDTO;
import com.websiteanvat.service.IUserService;

@RestController(value = "userAPIOfWeb")
public class UserAPI {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO createNews(@RequestBody UserDTO newsDTO) {
		return userService.save(newsDTO);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateNews(@RequestBody UserDTO newsDTO) {
		return userService.save(newsDTO);
	}
}
