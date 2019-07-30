package com.jzt.ruohe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO 
		http.formLogin() //  定义当需要用户登录时候，转到的登录页面
		.loginPage("/templates/login.html")
		.loginProcessingUrl("/user/login")
		.and()
		.authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
		.antMatchers("/blogserver/src/main/resources/templates/login.html")
		.permitAll()
		.anyRequest()  // 任何请求,登录后可以访问
		.authenticated()
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }

}
