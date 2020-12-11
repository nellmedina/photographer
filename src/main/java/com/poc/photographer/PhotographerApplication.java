package com.poc.photographer;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PhotographerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(PhotographerApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
									.select()
						            .apis(RequestHandlerSelectors.basePackage("com.poc.photographer.controller"))
								    .build()
								    .apiInfo(apiDetails());
    }
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Photographer POC for new joiners", 
				"Photographer POC for new joiners", 
				"1.0", 
				"Free to use", 
				null, 
				"API License", 
				null, 
				Collections.emptyList()
				);
	}
}
