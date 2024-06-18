package com.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Beans.Product;
import com.Ecommerce.Repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product saveProduct(Product product) {
		Product save = productRepo.save(product);
		return save;
	}
	
	public Product getProductById(Integer pid) {
		Product product = productRepo.findById(pid).orElseThrow();
		return product;
	}
	
	public List<Product> getAllProducts(){
		List<Product> all = productRepo.findAll();
		return all;
	}
	
	public Product removeProduct(Integer pid) {
		productRepo.deleteById(pid);
		return null;
	}
	
}
