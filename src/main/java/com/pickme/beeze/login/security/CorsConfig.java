package com.pickme.beeze.login.security;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {	// CORS(Cross-Origin Resource Sharing) 관련 설정
	
   @Bean
   public CorsFilter corsFilter() {
	  System.out.println("CorsConfig corsFilter " + new Date()); 
	   
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);		// 자격증명 허용
      config.addAllowedOriginPattern("*");	// 모든 출처에 대해 허용
      config.addAllowedHeader("*");			// 모든 헤더에 대해 허용
      config.addAllowedMethod("*");			// 모든 메서드에 대해 허용

      source.registerCorsConfiguration("/**", config);	// /** 이렇게 시작하는 모든 api에 대한 요청을 허용
      return new CorsFilter(source);
   }
}