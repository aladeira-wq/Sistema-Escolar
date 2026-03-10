package br.com.senai.sistema_escolar.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
 info = @Info(
    title = "Exemplo Sistema Escolar",
    version = "1.0",
    description = "API para sistema Exemplo Escolar"



    )


)

public class Swagger {
    
}
