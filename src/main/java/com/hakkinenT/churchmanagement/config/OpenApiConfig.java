package com.hakkinenT.churchmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(servers = { @Server(url = "https://localhost:8080")})
@Configuration
@SecurityScheme(name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        flows = @OAuthFlows(clientCredentials  = @OAuthFlow(tokenUrl = "${springdoc.oauthflow.tokenurl}",
                scopes = {@OAuthScope(name = "openid", description = "openid scope")
})))
public class OpenApiConfig {

    @Bean
    public OpenAPI churchManagementAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Church Management API")
                        .description("Church Management Reference Project")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/hakkinenT/spring-boot-church-management")));
    }
}
