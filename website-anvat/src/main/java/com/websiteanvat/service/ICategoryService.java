package com.websiteanvat.service;

import java.util.List;
import java.util.Map;

import com.websiteanvat.dto.CategoryDTO;

public interface ICategoryService {
	Map<String, String> findAll();
	List<CategoryDTO> findAllasList();
}
