package cs.matemaster.demo.config.externalize;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "app-info")
public class AppInfoConfig {

    private String server;

    private String port;

    private String name;

    private String description;
}
