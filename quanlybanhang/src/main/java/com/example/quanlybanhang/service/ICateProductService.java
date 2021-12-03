package com.example.quanlybanhang.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.dto.CateProductDTO;
import com.example.quanlybanhang.entites.CateProductEntity;

public interface ICateProductService {

	List<CateProductEntity> findAll();
	
	CateProductDTO save(CateProductDTO cateDTO, MultipartFile multipartFile);
	
	CateProductDTO findById(Long id);
	
	void delete(long[] ids);
	
}
