package com.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.category.exception.SequenceException;
import com.category.model.Category;
import com.category.service.ICategoryService;
import com.category.service.SequenceDao;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService service;

	@Autowired
	private SequenceDao sequenceDao;

	@PostMapping("/addCategory")
	public List<Category> addCategory(@RequestBody List<Category> categories) throws SequenceException {
		for (Category c : categories) {
			long sequenceid = sequenceDao.getNextSequenceId("categories");
			System.out.println("*********" + sequenceid + "********");
			c.setId(sequenceid);
		}
		return service.addCategory(categories);
	}

	@GetMapping("/{qname}")
	public List<Category> findCategoryByqName(@PathVariable("qname") String qName) {
		return service.getCategoryByName(qName);
	}
}
