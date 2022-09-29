package cs.matemaster.swagger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Data
@Configuration
public class SwaggerProperties {

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.enable}")
    private Boolean enable;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.version}")
    private String version;
}
