package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Autowired
	 BCryptPasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india"))
		.roles("admin").and().withUser("nepal").password(encoder.encode("nepal")).roles("guest");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().antMatchers("/api/v1/students/**").
//		permitAll().and().authorizeRequests().antMatchers("/api/v1/teachers/**").authenticated()
//		.and().httpBasic();
//		http.authorizeHttpRequests().antMatchers("/api/v1/students/**").
//		permitAll().and().authorizeRequests().antMatchers("/api/v1/teachers/**").
//		hasAnyRole("admin").and().httpBasic();
		http.authorizeHttpRequests().antMatchers("/api/v1/students/**").
		permitAll().and().authorizeRequests().antMatchers("/api/v1/teachers/**").
		hasAnyRole("admin").antMatchers("api/v1/staff/**").hasAnyRole("admin","guest").and().httpBasic();
	}
	 
	 

}
