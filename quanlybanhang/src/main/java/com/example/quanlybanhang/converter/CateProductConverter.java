package com.example.quanlybanhang.converter;

import org.springframework.stereotype.Component;

import com.example.quanlybanhang.dto.CateProductDTO;
import com.example.quanlybanhang.entites.CateProductEntity;

@Component
public class CateProductConverter {

public CateProductEntity toEntity(CateProductDTO dto) {
		
		CateProductEntity entity = new CateProductEntity();
		entity.setName(dto.getName());
		entity.setThumbnail(dto.getThumbnail());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public CateProductDTO toDTO(CateProductEntity entity) {
		
		CateProductDTO dto = new CateProductDTO();
		dto.setName(entity.getName());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCode(entity.getCode());
		dto.setContent(entity.getContent());
		return dto;
		
	}
	
	public CateProductEntity toEntity(CateProductDTO dto, CateProductEntity entity) {
		
		entity.setName(dto.getName());
		entity.setThumbnail(dto.getThumbnail());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		return entity;
	}
}
