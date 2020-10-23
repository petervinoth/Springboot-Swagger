package com.api.SwaggerApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("swagger").apiInfo(apiInfo()).select()
				.paths(regex("/2kdev.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employe Details")
				.description("Sample Documentation Generateed Using SWAGGER2 for Employee Details Rest API")
				.termsOfServiceUrl("https://www.youtube.com")
				.license("sample License")
				.licenseUrl("https://www.youtube.com").version("1.0").build();
	}
}