package cs.matemaster.swagger;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author matemaster
 */
@EnableSwagger2
@Configuration
@AllArgsConstructor
public class SwaggerConfig {

    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket docs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.getEnable())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description(swaggerProperties.getDescription())
                .title(swaggerProperties.getTitle())
                .version(swaggerProperties.getVersion())
                .build();
    }
}
