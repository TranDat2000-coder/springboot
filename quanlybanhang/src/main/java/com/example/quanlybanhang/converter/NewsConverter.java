package com.example.quanlybanhang.converter;

import org.springframework.stereotype.Component;

import com.example.quanlybanhang.dto.NewsDTO;
import com.example.quanlybanhang.entites.NewsEntity;

@Component
public class NewsConverter {

	public NewsEntity toEntity(NewsDTO dto) {
		
		NewsEntity entity = new NewsEntity();
		
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDesciption());
		entity.setContent(dto.getContent());
		return entity;
		
	}
	
	public NewsDTO toDTO(NewsEntity entity) {
		
		NewsDTO dto = new NewsDTO();
	
		dto.setTitle(entity.getTitle());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDesciption(entity.getShortDescription());
		dto.setContent(entity.getContent());
		return dto;
		
	}
	
	public NewsEntity toEntity(NewsDTO dto, NewsEntity entity) {
		
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDesciption());
		entity.setContent(dto.getContent());
		return entity;
		
	}
}
