package org.spu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/spu-sam_cards_creation.*"));
	}

	// http://localhost:8084/swagger-ui.html
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Sam Maina SPU API").description("Sam Maina SPU reference for developers")
				.termsOfServiceUrl("http://www.spu.ac.ke").contact("bbitnrb954014@spu.ac.ke")
				.license("Sam Maina Public License").licenseUrl("bbitnrb954014@spu.ac.ke").version("1.0").build();
	}

}
