package com.maslanka.out_of_office_solution_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

@Override
    public void addCorsMappings(CorsRegistry registry){
    registry.addMapping("/**")
            .allowedOrigins("http://Localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(false);
}
}
