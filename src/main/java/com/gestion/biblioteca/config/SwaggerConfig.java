package com.gestion.biblioteca.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biblioteca API")
                        .description("API para gestionar una biblioteca")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tu Nombre")
                                .email("tuemail@example.com")
                                .url("https://tu-sitio-web.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación completa")
                        .url("https://tu-sitio-documentacion.com"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor Local"),
                        new Server().url("https://api.tu-sitio.com").description("Servidor Producción")
                ));
    }
}