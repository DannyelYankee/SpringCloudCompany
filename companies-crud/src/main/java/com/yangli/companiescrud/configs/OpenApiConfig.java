package com.yangli.companiescrud.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "companies CRUD", version = "1.0.0", description = "This is a CRUD ffor management companies"))
public class OpenApiConfig {

}
