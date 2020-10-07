package com.websiteanvat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websiteanvat.converter.CategoryConverter;
import com.websiteanvat.dto.CategoryDTO;
import com.websiteanvat.entity.CategoryEntity;
import com.websiteanvat.repository.CategoryRepository;
import com.websiteanvat.service.ICategoryService;



@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item : entities) { 
			result.put(item.getCode(), item.getName());
		}
		return result;
	}


	@Override
	public List<CategoryDTO> findAllasList() {
		List<CategoryDTO> result = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item : entities) { 
			result.add(categoryConverter.toDTO(item));
		}
		return result;
	}

}
