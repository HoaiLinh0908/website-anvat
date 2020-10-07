package com.websiteanvat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websiteanvat.converter.ProductConverter;
import com.websiteanvat.dto.ProductDTO;
import com.websiteanvat.entity.CategoryEntity;
import com.websiteanvat.entity.ProductEntity;
import com.websiteanvat.repository.CategoryRepository;
import com.websiteanvat.repository.ProductRepository;
import com.websiteanvat.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for(ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDTO(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public Integer getTotalItem() {
		return (int) productRepository.count();
	}


	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity newsEntity = new ProductEntity();
		if(dto.getId() != null) {
			ProductEntity oldNews = productRepository.findOne(dto.getId());
			oldNews.setCategory(categoryEntity);
			newsEntity = productConverter.toEntity(oldNews, dto);
		}else {
			newsEntity = productConverter.toEntity(dto);
			newsEntity.setCategory(categoryEntity);
		}
		return productConverter.toDTO(productRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id : ids) {
			productRepository.delete(id);
		}
	}

	@Override
	public List<ProductDTO> findByCategoryCode(String code, Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByCategoryCode(code,pageable);
		List<ProductDTO> models = new ArrayList<>();
		
		for(ProductEntity item : entities) {
			ProductDTO productDTO = productConverter.toDTO(item);
			models.add(productDTO);
		}
		return models;
	}

	@Override
	public Integer getTotalItemByCategoryCode(String code) {
		return (int) productRepository.countByCategoryCode(code);
	}

	@Override
	public ProductDTO findByCode(String code) {
		ProductEntity entity = productRepository.findOneByCode(code);
		return productConverter.toDTO(entity);
	}

	@Override
	public ProductDTO findOneById(Long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDTO(entity);
	}

}
