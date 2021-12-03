package com.example.quanlybanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlybanhang.converter.InfoProductConvert;
import com.example.quanlybanhang.dto.InfoProductDTO;
import com.example.quanlybanhang.entites.InfoProductEntity;
import com.example.quanlybanhang.repository.InfoRepository;
import com.example.quanlybanhang.service.IInfoProductService;

@Service
public class InfoServiceImpl implements IInfoProductService {

	@Autowired
	private InfoProductConvert infoProductConvert;
	
	@Autowired
	private InfoRepository infoRepository;
	
	@Override
	public InfoProductDTO save(InfoProductDTO dto) {
		
		InfoProductEntity infoProductEntity = new InfoProductEntity();
		if(dto.getId() != null) {
			InfoProductEntity oldInfo = infoRepository.findOneById(dto.getId());
			infoProductEntity = infoProductConvert.toEntity(dto, oldInfo);
		}else {
			infoProductEntity = infoProductConvert.toEntity(dto);
		}
		
		infoProductEntity = infoRepository.save(infoProductEntity);
		
		return infoProductConvert.toDTO(infoProductEntity);
	}

	@Override
	public InfoProductDTO findById(Long id) {
		InfoProductEntity infoProductEntity = infoRepository.findOneById(id);
		return infoProductConvert.toDTO(infoProductEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			infoRepository.deleteById(item);
		}
		
	}

}
