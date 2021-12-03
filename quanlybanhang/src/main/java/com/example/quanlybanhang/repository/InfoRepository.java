package com.example.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quanlybanhang.entites.InfoProductEntity;

public interface InfoRepository extends JpaRepository<InfoProductEntity, Long>{

	 InfoProductEntity findOneById(Long id);
}
