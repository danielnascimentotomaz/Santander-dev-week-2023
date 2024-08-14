package me.dio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Santander Dev Week API")
                        .description("Santander Dev Week API")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@Santander.med"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://santander.med/api/licenca")));
    }


}
