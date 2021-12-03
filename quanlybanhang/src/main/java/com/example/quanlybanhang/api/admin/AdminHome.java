package com.example.quanlybanhang.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHome {

	@GetMapping(value = "/admin-trang-chu")
	private String homeAdmin() {
		return "/admin/homeadmin";
	}
}
