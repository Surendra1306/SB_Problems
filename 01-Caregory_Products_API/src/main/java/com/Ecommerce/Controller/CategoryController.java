package com.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.Beans.Category;
import com.Ecommerce.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		Category saveCategory = categoryService.saveCategory(category);
		return new ResponseEntity<>(saveCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> categories = categoryService.getAllCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Category> gatCatgoryById(@PathVariable("cid") Integer cid){
		return new ResponseEntity<>(categoryService.getCategoryById(cid),HttpStatus.OK);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("cid") Integer cid){
		categoryService.removeCategory(cid);
		return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<Category> updateCatgory(@RequestBody Category category,@PathVariable("cid") Integer cid) throws Exception{
		Category categoryById = categoryService.getCategoryById(cid);
		if(categoryById!=null) {
			categoryById.setCategoryId(category.getCategoryId());
			categoryById.setTitle(category.getTitle());
			Category updatedCategory = categoryService.saveCategory(categoryById);
			return new ResponseEntity<Category>(updatedCategory,HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}	
	
}









