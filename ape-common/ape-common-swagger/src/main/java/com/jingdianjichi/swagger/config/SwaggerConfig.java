package com.jingdianjichi.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Optional;
import com.jingdianjichi.swagger.bean.SwaggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Autowired
    private SwaggerInfo swaggerInfo;

    @Bean
    public Docket createUserApi() {
        return buildDocket("user");
    }

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .contact(new Contact(swaggerInfo.getContactName(),
                        swaggerInfo.getContactUrl(),
                        swaggerInfo.getEmail()))
                .version(swaggerInfo.getVersion())
                .description(swaggerInfo.getDescription())
                .build();
    }

    public Docket buildDocket(String groupName) {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName(groupName).select().apis(input -> {
            if (input.isAnnotatedWith(ApiVersion.class)) {
                Optional<ApiVersion> versionOptional = input.findAnnotation(ApiVersion.class);
                if (versionOptional.isPresent()) {
                    ApiVersion apiVersion = versionOptional.get();
                    if (apiVersion.value() != null && apiVersion.value().length != 0) {
                        if (Arrays.asList(apiVersion.value()).contains(groupName)) {
                            return true;
                        }
                    }
                }
            }
            Optional<ApiVersion> controllerAnnotation = input.findControllerAnnotation(ApiVersion.class);
            if (controllerAnnotation.isPresent()) {
                ApiVersion clzzApiVersion = controllerAnnotation.get();
                if (clzzApiVersion.value() != null && clzzApiVersion.value().length != 0) {
                    return Arrays.asList(clzzApiVersion.value()).contains(groupName);
                }
            }

            return false;
        }).paths(PathSelectors.any()).build();

    }

}

