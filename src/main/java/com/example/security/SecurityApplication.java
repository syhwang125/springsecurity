package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
 * spring.io 페이지의 guide 에 있는 샘플 https://spring.io/guides/gs/securing-web/ 
 * 유튜브 / 백기선 
 * [스프링 가이드] 스피링 시큐리티를 살짝 얹어보자 
 * https://www.youtube.com/watch?v=fG21HKnYt6g
 * spring security 를 이용해서 로그인시 인증을 받지 못하면 계속 로그인페이지로 이동함 
 */

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
