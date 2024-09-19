package com.sheblossoms.sheblossoms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	public void addCorsMapping(CorsRegistry registry) {
    	registry.addMapping("/api/**")
    	.allowedOrigins("*")
    	.allowedMethods("GET","POST","PUT","DELETE","PATCH", "OPTIONS","HEAD","TRACE","CONNECT");
    }
}
