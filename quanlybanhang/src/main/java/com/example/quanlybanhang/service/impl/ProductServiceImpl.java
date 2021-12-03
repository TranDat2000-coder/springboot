package com.example.quanlybanhang.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.converter.ProductConverter;
import com.example.quanlybanhang.dto.InfoProductDTO;
import com.example.quanlybanhang.dto.ProductDTO;
import com.example.quanlybanhang.entites.InfoProductEntity;
import com.example.quanlybanhang.entites.ProductEntity;
import com.example.quanlybanhang.repository.InfoRepository;
import com.example.quanlybanhang.repository.ProductRepository;
import com.example.quanlybanhang.service.IProductService;
import com.example.quanlybanhang.utils.CommonConstant;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private InfoRepository infoRepository;
	
	@Override
	public List<ProductDTO> findAll() {
		
		List<ProductEntity> productEntity = productRepository.findAll();
		List<ProductDTO> productDTO = new ArrayList<>();
		for(ProductEntity entity : productEntity) {
			ProductDTO dto = new ProductDTO();
			dto = productConverter.toDTO(entity);
			dto.setInfoId(entity.getInfo().getId());
			productDTO.add(dto);
		}
		return productDTO;
	}

	@Override
	public ProductDTO save(ProductDTO productDTO, InfoProductDTO infoDTO, MultipartFile multipartFile) {
		
		String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
		String rootPath = CommonConstant.root;
		Path pathFile = Paths.get(rootPath + filename);
		
		InfoProductEntity info = infoRepository.findOneById(infoDTO.getId());
		ProductEntity productEntity = new ProductEntity();
		
		if(productDTO.getId() != null) {
			ProductEntity oldProduct = productRepository.findOneById(productDTO.getId());
			oldProduct.setInfo(info);
			productEntity = productConverter.toEntity(productDTO, oldProduct);
		}else {
			productEntity = productConverter.toEntity(productDTO);
			productEntity.setInfo(info);
		}
		if(filename.charAt(filename.length() - 1) != '_') {
			try {
				productEntity.setThumbnail(filename);
				Files.copy(multipartFile.getInputStream(), pathFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		productEntity = productRepository.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public ProductDTO findById(Long id) {
		
		ProductEntity productEntity = productRepository.findOneById(id);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			productRepository.deleteById(item);
		}
	}

	@Override
	public List<ProductDTO> findByKeyWord(String keyword) {
		
		List<ProductEntity> productEntity = productRepository.findByKeyWord(keyword);
		List<ProductDTO> productDTO = new ArrayList<>();
		for(ProductEntity entity : productEntity) {
			ProductDTO dto = new ProductDTO();
			dto = productConverter.toDTO(entity);
			productDTO.add(dto);
		}
		return productDTO;
	}


	
}
