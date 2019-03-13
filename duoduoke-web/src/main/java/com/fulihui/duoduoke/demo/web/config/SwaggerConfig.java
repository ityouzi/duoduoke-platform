package com.fulihui.duoduoke.demo.web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${web.swagger-open}")
    private boolean swaggerOpen;


    /**
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(setHeaderToken()).enable(swaggerOpen)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.fulihui.duoduoke.demo.web.controller"))
                .paths(PathSelectors.any()).build();
    }


    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("").description("").termsOfServiceUrl("")
                .contact("").version("1.0").build();
    }

}
