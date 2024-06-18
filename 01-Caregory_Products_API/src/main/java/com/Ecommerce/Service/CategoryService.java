package com.Ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Beans.Category;
import com.Ecommerce.Repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category saveCategory(Category category) { 
		return categoryRepo.save(category);
	}
	
	public Category getCategoryById(Integer cid) {
		 Optional<Category> byId = categoryRepo.findById(cid);
		if(byId.isPresent()) {
			return byId.get();
		}
		else {
			return null;
		}
	}
	
	public List<Category> getAllCategories(){
		List<Category> all = categoryRepo.findAll();
		return all;
	}
	
	public void removeCategory(Integer cid)  {
		categoryRepo.deleteById(cid);	
	}
	
}










