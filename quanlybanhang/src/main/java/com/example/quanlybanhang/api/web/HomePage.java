package com.example.quanlybanhang.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePage {
	
	@GetMapping(value = "/trang-chu")
	private String homePages() {
		return "/homepage";
	}
}
