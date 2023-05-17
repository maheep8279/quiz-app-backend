package com.category.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.category.model.Category;

@Repository
public interface ICategoryRepository extends MongoRepository<Category,Long>{
    List<Category> findAllCategoryByqName(String qName);
}
