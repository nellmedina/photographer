package com.poc.photographer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
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
				.securityContexts(Collections.singletonList(securityContext()))
				.securitySchemes(Collections.singletonList(apiKey()))
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

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
	}
}
