package com.category.service;

import java.util.List;

import com.category.model.Category;

public interface ICategoryService {
   public List<Category> addCategory(List<Category> category);
   public List<Category> getCategoryByName(String qname);
}
