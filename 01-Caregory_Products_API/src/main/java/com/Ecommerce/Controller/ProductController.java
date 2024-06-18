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

import com.Ecommerce.Beans.Product;
import com.Ecommerce.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product saveProduct = productService.saveProduct(product);
		return new ResponseEntity<Product>(saveProduct,HttpStatus.CREATED);	
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer pid){
		Product productById = productService.getProductById(pid);
		return new ResponseEntity<Product>(productById,HttpStatus.OK);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer pid){
		Product removeProduct = productService.removeProduct(pid);
		return new ResponseEntity<>(removeProduct,HttpStatus.OK);
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Product> upddateProduct(@RequestBody Product product,
												  @PathVariable Integer pid){
		Product byId = productService.getProductById(pid);
		if(byId!=null) {
			Product updatedProduct = productService.saveProduct(byId);
			return ResponseEntity.ok(updatedProduct);
		}
		return ResponseEntity.notFound().build();
	}
	
}
