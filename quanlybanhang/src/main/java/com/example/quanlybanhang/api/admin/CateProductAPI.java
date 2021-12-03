package com.example.quanlybanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.dto.CateProductDTO;
import com.example.quanlybanhang.service.ICateProductService;

@Controller
public class CateProductAPI {

	@Autowired
	private ICateProductService cateProductService;
	
	@GetMapping(value = "/admin-danh-sach-the-loai-san-pham")
	public String categoryProductList(Model model) {
		model.addAttribute("categoryList", cateProductService.findAll());
		return "admin/category_product/cate_product_list";
		
	}
	
	@GetMapping(value = "/admin-the-loai")
	public String category(Model model, @RequestParam(value = "id", required = false) Long id) {
		CateProductDTO cateProductDTO = new CateProductDTO();
		if(id != null) {
			model.addAttribute("updateCate", cateProductService.findById(id));
		}
		
		model.addAttribute("addCate", cateProductDTO);
		return "admin/category_product/insert_category";
		
	}
	
	@PostMapping(value = "/admin-the-loai")
	public String putCategory(@ModelAttribute CateProductDTO cateProductDTO,
							  @RequestParam(value = "id", required = false) Long id,
							  @RequestParam(value = "file", required = false) MultipartFile file) {
		
		cateProductService.save(cateProductDTO, file);
		return "redirect:/admin-danh-sach-the-loai-san-pham?fsuccess";
	}
	
	
}
