package com.example.quanlybanhang.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.dto.InfoProductDTO;
import com.example.quanlybanhang.dto.ProductDTO;
import com.example.quanlybanhang.entites.ProductEntity;


public interface IProductService {

	List<ProductDTO> findAll();
	
	ProductDTO save(ProductDTO productDTO, InfoProductDTO infoDTO, MultipartFile multipartFile);
	
	ProductDTO findById(Long id);
	
	void delete(long[] ids);
	
	List<ProductDTO> findByKeyWord(String keyword);
	
}
