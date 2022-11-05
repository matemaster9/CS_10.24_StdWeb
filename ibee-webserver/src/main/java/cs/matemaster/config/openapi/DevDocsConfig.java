package cs.matemaster.config.openapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
public class DevDocsConfig {

    @Bean
    public OpenAPI devDocs() {

        Info info = new Info().title("DevDocs API")
                .description("Spring web application")
                .version("v1.0")
                .license(new License().name("Apache 2.0"));

        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("StdWeb")
                .url("https://github.com/matemaster9/StdWeb");

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }
}
