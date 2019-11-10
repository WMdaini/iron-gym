package com.ayya.sport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayya.sport.entity.Category;
import com.ayya.sport.repository.CategoryRepository;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin("*")
public class CategoryConroller {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<Category> getCategorys() {
		
		return categoryRepository.findAll();
	}
	
	@RequestMapping(value = "setStatus/{id}", method = RequestMethod.PUT)
	public Category setCategoryStatus(@PathVariable Long id) {
		Category category = categoryRepository.findByIdCategory(id);
		category.setStatus(!category.isStatus());
		return 	category;
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public Category getCategoryById(@PathVariable Long id) {
		
		return categoryRepository.findByIdCategory(id);
	}
	
	@RequestMapping(value = "/delete/{idCategory}", method = RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable Long idCategory) {
		
		 categoryRepository.deleteById(idCategory);
		 return true ;
	}
	

	@RequestMapping(value = "/update/{idCategory}", method = RequestMethod.PUT)
	public Category updateCategorie( @RequestBody Category category , @PathVariable Long idCategory) {
		 category.setIdCategory(idCategory);
		Category category1= categoryRepository.saveAndFlush(category);
		 return category1 ;
	}
	
	
	
	

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public Category updateCategorie( @RequestBody Category category) {
	return categoryRepository.save(category);
		
	}
	
	
}
