//package com.example.quanlybanhang.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.example.quanlybanhang.service.IUserService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private IUserService userService;
//	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//     
//        http.authorizeRequests()
//        .antMatchers("/admin**").hasAuthority("ADMIN")
//        .and()
//        .formLogin()
//        .loginPage("/dang-nhap")
//        .permitAll()
//        .and()
//        .logout()
//        .invalidateHttpSession(true)
//        .clearAuthentication(true)
//        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//        .logoutSuccessUrl("/dang-nhap")
//        .permitAll();
//        
//        http.authorizeRequests().antMatchers("/**").permitAll();
//    }
//    
//    
//}
