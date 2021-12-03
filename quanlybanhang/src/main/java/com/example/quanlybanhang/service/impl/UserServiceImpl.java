package com.example.quanlybanhang.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.example.quanlybanhang.dto.MyUser;
import com.example.quanlybanhang.entites.RoleEntity;
import com.example.quanlybanhang.entites.UserEntity;
import com.example.quanlybanhang.repository.UserRepository;
import com.example.quanlybanhang.service.IUserService;
import com.example.quanlybanhang.utils.SecurityUtils;

@Service
public class UserServiceImpl extends SimpleUrlAuthenticationSuccessHandler implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUserName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isAdmin(roles)) {
			url = "/home-admin";
		} else if (isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;
	}

}
