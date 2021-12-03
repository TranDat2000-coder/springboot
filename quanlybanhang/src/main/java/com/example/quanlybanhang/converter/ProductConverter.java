package com.example.quanlybanhang.converter;

import org.springframework.stereotype.Component;

import com.example.quanlybanhang.dto.ProductDTO;
import com.example.quanlybanhang.entites.ProductEntity;

@Component
public class ProductConverter {

	public ProductEntity toEntity(ProductDTO dto) {

		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setName(dto.getName());
		productEntity.setThumbnail(dto.getThumbnail());
		productEntity.setPrice(dto.getPrice());
		productEntity.setPriceSale(dto.getPriceSale());
		productEntity.setDescription(dto.getDescription());
		productEntity.setShortDescription(dto.getShortDescription());
		return productEntity;
	}

	public ProductDTO toDTO(ProductEntity entity) {

		ProductDTO productDTO = new ProductDTO();
		if(entity.getId() != null) {
			productDTO.setId(entity.getId());
		}
		productDTO.setName(entity.getName());
		productDTO.setThumbnail(entity.getThumbnail());
		productDTO.setPrice(entity.getPrice());
		productDTO.setPriceSale(entity.getPriceSale());
		productDTO.setDescription(entity.getDescription());
		productDTO.setShortDescription(entity.getShortDescription());
		productDTO.setCreateBy(entity.getCreateBy());
		productDTO.setCreateDate(entity.getCreateDate());
		productDTO.setModifiledBy(entity.getModifiledBy());
		productDTO.setModifiedDate(entity.getModifiedDate());
		productDTO.setInfoId(entity.getInfo().getId());
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		
		entity.setName(dto.getName());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		entity.setPriceSale(dto.getPriceSale());
		entity.setDescription(dto.getDescription());
		entity.setShortDescription(dto.getShortDescription());
		return entity;
	}
}
