package com.example.quanlybanhang.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.converter.CateProductConverter;
import com.example.quanlybanhang.dto.CateProductDTO;
import com.example.quanlybanhang.entites.CateProductEntity;
import com.example.quanlybanhang.repository.CateProductRepository;
import com.example.quanlybanhang.service.ICateProductService;
import com.example.quanlybanhang.utils.CommonConstant;

@Service
public class CateProductService implements ICateProductService {

	@Autowired
	private CateProductRepository cateProductRepository;
	
	@Autowired
	private CateProductConverter cateProductConverter;
	
	@Override
	public List<CateProductEntity> findAll() {
		return cateProductRepository.findAll();
	}

	@Override
	public CateProductDTO save(CateProductDTO cateDTO, MultipartFile multipartFile) {
		
		String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
		String rootPath = CommonConstant.cate;
		Path pathFile = Paths.get(rootPath + filename);
		
		CateProductEntity cateProductEntity = new CateProductEntity();
		if(cateDTO != null) {
			CateProductEntity oldCate = cateProductRepository.findOneById(cateDTO.getId());
			cateProductEntity = cateProductConverter.toEntity(cateDTO, oldCate);
		}else {
			cateProductEntity = cateProductConverter.toEntity(cateDTO);
		}
		if(filename.charAt(filename.length() - 1) != '_') {
			try {
				cateProductEntity.setThumbnail(filename);
				Files.copy(multipartFile.getInputStream(), pathFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cateProductEntity = cateProductRepository.save(cateProductEntity);
		return cateProductConverter.toDTO(cateProductEntity);
	}

	@Override
	public CateProductDTO findById(Long id) {
		
		CateProductEntity cateProductEntity = cateProductRepository.findOneById(id);
		return cateProductConverter.toDTO(cateProductEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			cateProductRepository.deleteById(item);
		}
		
	}

}
