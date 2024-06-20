package com.shopping.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByIsActiveTrue();

	List<Product> findByCategory(String category);

	Page<Product> findByIsActiveTrue(Pageable pageable);

	Page<Product> findByCategoryAndIsActiveTrue(String category, Pageable pageable);
}
