package com.example.quanlybanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.quanlybanhang.dto.InfoProductDTO;
import com.example.quanlybanhang.dto.ProductDTO;
import com.example.quanlybanhang.entites.ProductEntity;
import com.example.quanlybanhang.dto.NewsDTO;
import com.example.quanlybanhang.repository.InfoRepository;
import com.example.quanlybanhang.repository.ProductRepository;
import com.example.quanlybanhang.service.IInfoProductService;
import com.example.quanlybanhang.service.IProductService;


@Controller
public class ProductAPI {
	
	@Autowired
	private IProductService productService;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private IInfoProductService infoProductService;
	
	@Autowired
	private InfoRepository infoRepository;
	
	@GetMapping(value = "/admin-danh-sach-san-pham")
	public String findAll(Model model) {
		model.addAttribute("productList", productService.findAll());
		return "admin/products/list_product";
		
	}
	
	@RequestMapping(path = "/admin-search")
	public String search(Model model, String keyword) {
		if(keyword != null) {
			model.addAttribute("productList", productService.findByKeyWord(keyword));
		}
		return "admin/products/list_product";
		
	}
	
	@GetMapping(value = "/admin/san-pham")
	public String product(Model model,@RequestParam(value = "id", required = false) Long id,
									  @RequestParam(value = "info", required = false)Long info){
		ProductDTO productDTO = new ProductDTO();
		InfoProductDTO infoProductDTO = new InfoProductDTO();
		if(id != null && info != null) {
			model.addAttribute("addProduct", productService.findById(id));
			model.addAttribute("addInfo", infoProductService.findById(id));
		}
		model.addAttribute("product", productDTO);
		model.addAttribute("info", infoProductDTO);
	
		return "admin/products/insert_product";
	}
	
	@PostMapping(value = "/admin/san-pham")
	public String insertProduct(@ModelAttribute ProductDTO productDTO,
								@ModelAttribute InfoProductDTO infoProductDTO,
								@RequestParam(value = "id", required = false) Long id,
			  					@RequestParam(value = "info", required = false)Long info,
			  					@RequestParam(value = "file", required = false)MultipartFile file) {
		InfoProductDTO infoPost = infoProductService.save(infoProductDTO);
		infoProductDTO.setId(infoPost.getId());
		productService.save(productDTO, infoPost, file);
		return "redirect:/admin-danh-sach-san-pham?fsuccess";
		
	}
	
	@PutMapping(value = "/admin/san-pham/{id}")
	public String updateProduct(@RequestParam(value = "id") Long id,
								@RequestParam(value = "info") Long info,
								@RequestParam(value = "file")MultipartFile file,
								@ModelAttribute ProductDTO productDTO,
								@ModelAttribute InfoProductDTO infoProductDTO) {
		productDTO.setId(id);
		infoProductDTO.setId(info);
		productService.save(productDTO, infoProductDTO, file);
		return "redirect:/admin-danh-sach-san-pham?fsuccess";
		
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		infoRepository.deleteById(id);
		return "redirect:/admin-danh-sach-san-pham?fsuccess";
	}
}
