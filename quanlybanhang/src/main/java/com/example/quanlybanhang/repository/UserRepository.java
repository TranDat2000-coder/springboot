package com.example.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlybanhang.entites.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserName(String username);
}
