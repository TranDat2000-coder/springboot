package com.example.quanlybanhang.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quanlybanhang.service.IInfoProductService;
import com.example.quanlybanhang.service.IProductService;
import com.example.quanlybanhang.service.impl.InfoServiceImpl;
import com.example.quanlybanhang.service.impl.ProductServiceImpl;

@Controller
public class WebProductAPI {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IInfoProductService infoProductService;
	
	@GetMapping(value = "/danh-sach-san-pham")
	private String listProduct(Model model) {
		model.addAttribute("productList", productService.findAll());
		return "/product_list";
	}
	
	@GetMapping(value = "/chi-tiet-san-pham")
	private String showItem(Model model,@RequestParam(value = "id") Long id,
										@RequestParam(value = "info") Long info) {
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("info", infoProductService.findById(info));
		return "/product";
	}
}
