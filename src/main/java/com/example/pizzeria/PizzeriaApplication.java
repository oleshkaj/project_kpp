package com.example.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.example.pizzeria"})
public class PizzeriaApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(PizzeriaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() // повертає об'єкт WebMvcConfigurer, який додає правила для CORS (Cross-Origin Resource Sharing) - правила для взаємодії фронтенду і бекенду
	{
		return new WebMvcConfigurer()
		{
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry)
			{
				registry.addMapping("/**") // дозволяє всі шляхи API
						.allowedOrigins("http://localhost:5173") // домен фронту
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true); // дозвіл передавати кукі між доменами
			}
		};
	}
}