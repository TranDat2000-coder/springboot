package com.example.quanlybanhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.quanlybanhang.entites.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	ProductEntity findOneById(Long id);
	
	@Query(value = "SELECT * FROM product p WHERE p.name like %?1%", nativeQuery = true)
	List<ProductEntity> findByKeyWord(String keyword);
}
