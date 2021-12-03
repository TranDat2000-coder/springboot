package com.example.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlybanhang.entites.CateProductEntity;

public interface CateProductRepository extends JpaRepository<CateProductEntity, Long> {
	
	CateProductEntity findOneById(Long id);

}
