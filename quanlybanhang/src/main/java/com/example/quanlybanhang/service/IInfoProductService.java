package com.example.quanlybanhang.service;

import com.example.quanlybanhang.dto.InfoProductDTO;

public interface IInfoProductService {
	
	InfoProductDTO save(InfoProductDTO dto);
	
	InfoProductDTO findById(Long id);
	
	void delete(long[] ids);
}
