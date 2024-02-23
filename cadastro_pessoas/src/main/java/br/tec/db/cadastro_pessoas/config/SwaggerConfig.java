package br.tec.db.cadastro_pessoas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("api-public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customApi(){
        return new OpenAPI()
                .info(new Info().title("Cadastro de Pessoas").version("1.0"));
    }
}
