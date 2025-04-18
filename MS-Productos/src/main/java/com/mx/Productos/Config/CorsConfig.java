package com.mx.Productos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig {
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/Productos/**")
				.allowedOriginPatterns("*")
				.allowedOrigins("GET", "POST", "PUT", "DELETE")
				.maxAge(3600);
			
			}
			
		};
		
	}
}
