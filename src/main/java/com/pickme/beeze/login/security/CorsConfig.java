package com.pickme.beeze.login.security;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
   @Bean
   public CorsFilter corsFilter() {
	  System.out.println("CorsConfig corsFilter " + new Date()); 
	   
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOriginPattern("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");

      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }
}
