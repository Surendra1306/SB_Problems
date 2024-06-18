package com.Ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Beans.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
