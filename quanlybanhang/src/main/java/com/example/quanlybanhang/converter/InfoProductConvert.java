package com.example.quanlybanhang.converter;

import org.springframework.stereotype.Component;

import com.example.quanlybanhang.dto.InfoProductDTO;
import com.example.quanlybanhang.entites.InfoProductEntity;

@Component
public class InfoProductConvert {

	public InfoProductEntity toEntity(InfoProductDTO dto) {

		InfoProductEntity info = new InfoProductEntity();
		
		info.setCompany(dto.getCompany());
		info.setHeight(dto.getHeight());
		info.setWeight(dto.getWeight());
		info.setRomPhone(dto.getRomPhone());
		info.setRamPhone(dto.getRamPhone());
		info.setScreenSize(dto.getScreenSize());
		info.setSystemVersion(dto.getSystemVersion());
		info.setChipset(dto.getChipset());
		info.setPinPhone(dto.getPinPhone());

		return info;
	}

	public InfoProductDTO toDTO(InfoProductEntity entity) {

		InfoProductDTO dto = new InfoProductDTO();
		dto.setId(entity.getId());
		dto.setCompany(entity.getCompany());
		dto.setHeight(entity.getHeight());
		dto.setWeight(entity.getWeight());
		dto.setRomPhone(entity.getRomPhone());
		dto.setRamPhone(entity.getRamPhone());
		dto.setScreenSize(entity.getScreenSize());
		dto.setSystemVersion(entity.getSystemVersion());
		dto.setChipset(entity.getChipset());
		dto.setPinPhone(entity.getPinPhone());

		return dto;
	}

	public InfoProductEntity toEntity(InfoProductDTO dto, InfoProductEntity entity) {

		entity.setCompany(dto.getCompany());
		entity.setHeight(dto.getHeight());
		entity.setWeight(dto.getWeight());
		entity.setRomPhone(dto.getRomPhone());
		entity.setRamPhone(dto.getRamPhone());
		entity.setScreenSize(dto.getScreenSize());
		entity.setSystemVersion(dto.getSystemVersion());
		entity.setChipset(dto.getChipset());
		entity.setPinPhone(dto.getPinPhone());

		return entity;
	}
}
