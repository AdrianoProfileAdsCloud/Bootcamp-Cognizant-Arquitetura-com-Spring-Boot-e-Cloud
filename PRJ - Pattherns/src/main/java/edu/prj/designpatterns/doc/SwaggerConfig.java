package edu.prj.designpatterns.doc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato() {
        return new Contact(
                "Adriano Aparecido da Silva",
                "www.linkedin.com/in/adssolutions",
                "adrianoprogm@hotmail.com");
    }

    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Bootcamp Dio - Cognizant - Arquitetura com Spring Boot e Cloud");
        apiInfoBuilder.description("Criação de uma solução para explorar o conceito de Padrões de Projeto na prática com Spring Boot");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Projeto - Projeto de conclusão de Módulo");
        apiInfoBuilder.licenseUrl("https://github.com/AdrianoProfileAdsCloud");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.prj.designpatterns"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .securityContexts(securityContext()) //JWT na API com Swagger
                .securitySchemes(listApiKey()) //JWT na API com Swagger
                .consumes(new HashSet<>(List.of("application/json")))
                .produces(new HashSet<>(List.of("application/json")));

        return docket;
    }

        /*
            Inicio - JWT na API com Swagger.
         */
    private List<ApiKey> listApiKey(){
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("JWT","Authorization","header"));
        return apiKeys;
    }
    private List<SecurityContext> securityContext(){
        List<SecurityContext> list = new ArrayList<>();
        list.add(SecurityContext.builder().securityReferences(defaultAth()).build());
        return  list;
    }

    private List<SecurityReference> defaultAth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("JWT", authorizationScopes));
    }
    /*
        Fim - JWT na API com Swagger
     */
}

