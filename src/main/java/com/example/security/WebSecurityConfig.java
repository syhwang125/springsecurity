package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
		 .authorizeRequests()
         .antMatchers("/", "/home", "/create").permitAll()
//         .antMatchers("/admin/**").hasRole("ADMIN")
         .anyRequest().authenticated()
         .and()
     .formLogin()
         .loginPage("/login")
         .permitAll()
         .and()
     .logout()
     	 .logoutSuccessUrl("/home")
         .permitAll();
}
	
	// there is no passwordencoder mapped for the id "null" exception 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);

	}*/
}
