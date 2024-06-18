package com.Ecommerce.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.Beans.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
