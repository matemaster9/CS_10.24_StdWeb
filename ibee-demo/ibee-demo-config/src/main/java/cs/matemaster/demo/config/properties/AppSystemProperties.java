package cs.matemaster.demo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties("app.system")
public class AppSystemProperties {

    private Map<String, String> monthMap;
}
