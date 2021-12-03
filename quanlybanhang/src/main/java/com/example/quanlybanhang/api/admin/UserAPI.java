package com.example.quanlybanhang.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAPI {

	@GetMapping(value = "/dang-nhap")
	public String login() {
		return "login";
	}
}
