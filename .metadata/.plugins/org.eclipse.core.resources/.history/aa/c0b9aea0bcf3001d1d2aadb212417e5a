package com.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category.model.Category;
import com.category.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepo;

	@Override
	public List<Category> addCategory(List<Category> categories) {
		return categoryRepo.insert(categories);
	}

	@Override
	public List<Category> getCategoryByName(String qname) {
		return categoryRepo.findAllCategoryByqName(qname);
	}

}
